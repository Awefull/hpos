package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.ArticleService;
import com.heeexy.example.service.AttachmentsService;
import com.heeexy.example.util.CommonUtil;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author: wwq
 * @description: 附件上传controller
 * @date: 2019/3/24 17:50
 */
@RestController
@RequestMapping("/attachments")
public class AttachmentsController {
    @Autowired
    private AttachmentsService attachmentsService;

    @PostMapping(value = "/saveAttachments")
    public JSONObject saveAttachments(@RequestParam("multipartfiles") MultipartFile file,HttpServletRequest request,@RequestParam("unitName") String unitName,@RequestParam("applicationDays")int applicationDays,@RequestParam("amount")int amount) throws IOException {

        File path = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath());
        String filePath = path.getParentFile() + File.separator + "hpos" + File.separator + "attachments" +  File.separator + "attachment";
        File newPath = new File(filePath);
        if (!path.exists()) path.mkdirs();
        String originalFileName = file.getOriginalFilename();
        String newFileName = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS").format(new Date()) + new Random().nextInt(10);
        int index = originalFileName.lastIndexOf(".");
        if (index != -1) {
            String suffix = originalFileName.substring(index, originalFileName.length()).toLowerCase();
            newFileName = newFileName + suffix;
        }
        File f = new File(newPath, newFileName);
        file.transferTo(f);

        String file_path = "/hpos/attachments/attachment";
        JSONObject attachment = new JSONObject();
        int fileNum = attachmentsService.getFileNum();
        attachment.put("fileName",newFileName);
        attachment.put("filePath",file_path);
        attachment.put("fileTitle",originalFileName);
        attachment.put("fileId",fileNum+1);
        attachmentsService.saveAttachments(attachment);
        //到这里为止，文件以及保存到服务器上，并且将图片的相关信息存储到了数据库
        JSONObject advertisementMessage = new JSONObject();
        advertisementMessage.put("unitName",unitName);
        advertisementMessage.put("applicationDays",applicationDays);
        advertisementMessage.put("attachmentId",fileNum+1);
        advertisementMessage.put("amount",amount);
        attachmentsService.addAttachmentIdToAdvertisementByFileName(advertisementMessage);
        return CommonUtil.successJson();
    }

    @PostMapping(value = "/advertisementApplication")
    public JSONObject advertisementApplication(@RequestBody JSONObject requestJson) throws IOException {
        CommonUtil.hasAllRequired(requestJson,"unitName,advApplicationDays,price");
        return CommonUtil.successJson();
    }

    /**
     * 查询审核结果
     */
    @PostMapping("/getResultsList")
    public JSONObject getResultsList(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName");
        return attachmentsService.getResultsList(requestJson);
    }

}

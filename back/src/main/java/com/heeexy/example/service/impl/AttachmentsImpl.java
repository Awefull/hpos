package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.ArticleDao;
import com.heeexy.example.dao.AttachmentsDao;
import com.heeexy.example.service.AttachmentsService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentsImpl implements AttachmentsService {

    @Autowired
    private AttachmentsDao attachmentsDao;

    public JSONObject saveAttachments(JSONObject jsonObject){
        int returnId = attachmentsDao.saveAttachments(jsonObject);
        return CommonUtil.successJson();
    }

    public int getFileNum(){
        return attachmentsDao.getFileNum();
    }

    public JSONObject addAttachmentIdToAdvertisementByFileName(JSONObject jsonObject){
        attachmentsDao.addAttachmentIdToAdvertisementByFileName(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 查询审核结果
     */
    @Override
    public JSONObject getResultsList(JSONObject jsonObject) {
        List<JSONObject> list = attachmentsDao.getResultsList(jsonObject);
        int count = list.size();
        return CommonUtil.successPage(list, count);
    }
}

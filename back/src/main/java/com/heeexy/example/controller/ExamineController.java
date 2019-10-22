package com.heeexy.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.ExamineService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Examine")
public class ExamineController {
    @Autowired
    private ExamineService ExamineService;

    /**
     * 查询企业用户到列表
     */
    @GetMapping("/getCompanyNotExamineAccountList")
    public JSONObject listCompanyNotExamineAccount(HttpServletRequest request) {
        return ExamineService.listCompanyNotExamineAccount(CommonUtil.request2Json(request));
    }

    /**
     * 查询工作室用户到列表
     */
    @GetMapping("/getStudioNotExamineAccountList")
    public JSONObject listStudioNotExamineAccount(HttpServletRequest request) {
        return ExamineService.listStudioNotExamineAccount(CommonUtil.request2Json(request));
    }

    /**
     * 查询广告审核到列表
     */
    @GetMapping("/getAdvertisementNotExamineList")
    public JSONObject listAdvertisementNotExamine(HttpServletRequest request) {
        return ExamineService.listAdvertisementNotExamine(CommonUtil.request2Json(request));
    }

    /**
     * 更新审核通过的账户
     */
    @PostMapping("/updateExamineAccount")
    public JSONObject updateExamineAccount(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "username, email, address, telephone, unit_name, is_examined");
        return ExamineService.updateExamineAccount(requestJson);
    }

    /**
     * 更新审核不通过的账户
     */
    @PostMapping("/updateNoExamineAccount")
    public JSONObject updateNoExamineAccount(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "username, email, address, telephone, unit_name, is_examined");
        return ExamineService.updateNoExamineAccount(requestJson);
    }

    /**
     * 更新审核通过的广告
     */
    @PostMapping("/updateAdvertisementExamine")
    public JSONObject updateAdvertisementExamine(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName, applicationDays, amount, attachmentId, auditResults, updateDate");
        return ExamineService.updateAdvertisementExamine(requestJson);
    }

    /**
     * 更新审核不通过的广告
     */
    @PostMapping("/updateAdvertisementNoExamine")
    public JSONObject updateAdvertisementNoExamine(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName, applicationDays, amount, attachmentId, auditResults, updateDate");
        return ExamineService.updateAdvertisementNoExamine(requestJson);
    }
}

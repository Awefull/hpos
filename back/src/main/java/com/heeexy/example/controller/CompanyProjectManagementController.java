package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.CompanyProjectManagementService;
import com.heeexy.example.service.EvaluateService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/companyProjectManagement")
public class CompanyProjectManagementController {
    @Autowired
    private CompanyProjectManagementService CompanyProjectManagementService;

    @Autowired
    private EvaluateService evaluateService;

    /**
     * 增加项目到招募列表
     */
    @PostMapping("/addNotRecruitedProject")
    public JSONObject addNotRecruitedProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName, projectName, projectBudget,projectDescription");
        return CompanyProjectManagementService.addNotRecruitedProject(requestJson);
    }

    /**
     * 查询项目未招募列表
     */
    @GetMapping("/getNotRecruitedList")
    public JSONObject listCompanyProjectNotRecruited(HttpServletRequest request) {
        return CompanyProjectManagementService.listCompanyProjectNotRecruited(CommonUtil.request2Json(request));
    }

    /**
     * 查询招募工作室列表
     */
    @PostMapping("/getRecruiteList")
    public JSONObject getRecruiteList(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName");
        return CompanyProjectManagementService.getRecruiteList(requestJson);
    }

    /**
     * 查询招募工作室列表
     */
    @PostMapping("/getRecruitedList")
    public JSONObject getRecruitedList(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName");
        return CompanyProjectManagementService.getRecruitedList(requestJson);
    }
    /**
     * 更新未招募列表中的项目
     */
    @PostMapping("/updateNotRecruitedProject")
    public JSONObject updateNotRecruitedProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, tenderStatus, companyName, deleteStatus, studioName");
        return CompanyProjectManagementService.updateNotRecruitedProject(requestJson);
    }
    /**
     * 增加项目到进行列表
     */
    @PostMapping("/addProgressList")
    public JSONObject addProgressList(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "companyName, projectName, studioName,deposit, projectDescription");
        return CompanyProjectManagementService.addProgressList(requestJson);
    }

    /**
     * 更新进行列表中的项目
     */
    @PostMapping("/updateProgressProject")
    public JSONObject updateProgressProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName, deleteStatus");
        return CompanyProjectManagementService.updateProgressProject(requestJson);
    }

    /**
     * 申请支付尾款
     */
    @PostMapping("/applyForFinalPayment")
    public JSONObject applyForFinalPayment(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName, studioName");
        return CompanyProjectManagementService.applyForFinalPayment(requestJson);
    }

    /**
     * 查询项目进行中列表
     */
    @GetMapping("/getProgressList")
    public JSONObject listCompanyProjectProgress(HttpServletRequest request) {
        return CompanyProjectManagementService.listCompanyProjectProgress(CommonUtil.request2Json(request));
    }

    /**
     * 查询某项目的日志
     */
    @PostMapping("/getProjectProgressLog")
    public JSONObject getProjectProgressLog(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName");
        return CompanyProjectManagementService.getProjectProgressLog(requestJson);
    }

    /**
     * 查询某项目的申请消息
     */
    @PostMapping("/getApplyList")
    public JSONObject getApplyList(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName, studioName");
        return CompanyProjectManagementService.getApplyList(requestJson);
    }

    /**
     * 增加项目到完成列表
     */
    @PostMapping("/addFinishedList")
    public JSONObject addFinishedList(@RequestBody JSONObject requestJson) throws Exception {
        CommonUtil.hasAllRequired(requestJson, "companyName, projectName, studioName,evaluateDemand,evaluateAbility,evaluatePlan,budget, projectDescription");
//        CommonUtil commonUtil = new CommonUtil();
//        JSONObject finalEvaluate = commonUtil.evaluate(requestJson);
        JSONObject finalEvaluate = evaluateService.evaluate(requestJson);
        requestJson.remove("evaluateDemand");
        requestJson.put("evaluateDemand",finalEvaluate.getString("finalDemand"));
        requestJson.remove("evaluateAbility");
        requestJson.put("evaluateAbility",finalEvaluate.getString("finalAbility"));
        requestJson.remove("evaluatePlan");
        requestJson.put("evaluatePlan",finalEvaluate.getString("finalPlan"));
        requestJson.remove("evaluate");
        requestJson.put("evaluate",finalEvaluate.getString("evaluate"));
        return CompanyProjectManagementService.addFinishedList(requestJson);
    }

    /**
     * 更新完成列表中的项目
     */
    @PostMapping("/updateFinishedProject")
    public JSONObject updateFinishedProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName, deleteStatus");
        return CompanyProjectManagementService.updateFinishedProject(requestJson);
    }

    /**
     * 查询项目完成列表
     */
    @GetMapping("/getFinishedList")
    public JSONObject listCompanyProjectFinished(HttpServletRequest request) {
        return CompanyProjectManagementService.listCompanyProjectFinished(CommonUtil.request2Json(request));
    }

}

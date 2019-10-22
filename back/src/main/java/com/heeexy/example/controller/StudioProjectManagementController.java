package com.heeexy.example.controller;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.StudioProjectManagementService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/studioProjectManagement")
public class StudioProjectManagementController {
    @Autowired
    private StudioProjectManagementService studioProjectManagementService;
    /**
     * 查询招标中项目列表
     */
    @GetMapping("/studioNotRecruitedList")
    public JSONObject listStudioNotRecruited(HttpServletRequest request) {
        return studioProjectManagementService.listStudioNotRecruited(CommonUtil.request2Json(request));
    }
    /**
     * 更新未被募的工作室中的招募状态
     */
    @PostMapping("/updateNotRecruitedBidStatus")
    public JSONObject updateNotRecruitedBidStatus(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName, studioName,projectDescription");
        return studioProjectManagementService.updateNotRecruitedBidStatus(requestJson);
    }

    /**
     * 更新招标中列表中的项目
     */
    @PostMapping("/updateNotRecruitedProject")
    public JSONObject updateNotRecruitedProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, bidStatus, studioName, deleteStatus");
        return studioProjectManagementService.updateNotRecruitedProject(requestJson);
    }




    @PostMapping("/addStudioNotRecruited")
    public JSONObject addStudioNotRecruited(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, deposit, finalPayment,  companyName, projectDescription");
        return studioProjectManagementService.addStudioNotRecruited(requestJson);
    }

    /**
     * 查询进行中项目列表
     */
    @GetMapping("/studioProgressList")
    public JSONObject listStudioProgress(HttpServletRequest request) {
        return studioProjectManagementService.listStudioProgress(CommonUtil.request2Json(request));
    }

    @PostMapping("/addStudioProgress")
    public JSONObject addStudioProgress(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, deposit, companyName, projectDescription");
        return studioProjectManagementService.addStudioProgress(requestJson);
    }

    @PostMapping("/updateStudioProgress")
    public JSONObject updateStudioProgress(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, " projectName,   projectProgress, studioName, deleteStatus");
        return studioProjectManagementService.updateStudioProgress(requestJson);
    }

    /**
     * 增加进度
     */
    @PostMapping("/addLog")
    public JSONObject addLog(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectProgress, projectName, studioName,companyName");
        return studioProjectManagementService.addLog(requestJson);
    }

    /**
     * 查询某项目的日志
     */
    @PostMapping("/getProjectProgressLog")
    public JSONObject getProjectProgressLog(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, studioName");
        return studioProjectManagementService.getProjectProgressLog(requestJson);
    }

    /**
     * 删除进行中的某项目
     */
    @PostMapping("/deleteStudioProgress")
    public JSONObject deleteStudioProgress(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, " projectName,companyName, studioName");
        return studioProjectManagementService.deleteStudioProgress(requestJson);
    }

    /**
     * 查询已完成项目列表
     */
    @GetMapping("/studioFinishedList")
    public JSONObject listStudioFinished(HttpServletRequest request) {
        return studioProjectManagementService.listStudioFinished(CommonUtil.request2Json(request));
    }

    @PostMapping("/addStudioFinished")
    public JSONObject addStudioFinished(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, budget, companyName, evaluate,studioName,projectDescription");
        return studioProjectManagementService.addStudioFinished(requestJson);
    }

    /**
     * 更新完成列表中的项目
     */
    @PostMapping("/updateFinishedProject")
    public JSONObject updateFinishedProject(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, studioName, deleteStatus");
        return studioProjectManagementService.updateFinishedProject(requestJson);
    }

    /**
     * 查询招标中项目列表
     */
    @GetMapping("/countProjectNum")
    public JSONObject countProjectNum(HttpServletRequest request) {
        return studioProjectManagementService.countProjectNum(CommonUtil.request2Json(request));
    }

}

package com.heeexy.example.controller;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.ProjectMessageService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/projectMessage")

public class ProjectMessageController {

    @Autowired
    private ProjectMessageService projectMessageService;

    /**
     * 项目信息列表
     */
    @RequiresPermissions("user:list")
    @GetMapping("/list")
    public JSONObject listProjectMessage(HttpServletRequest request) {
        return projectMessageService.listProjectMessage(CommonUtil.request2Json(request));
    }

    /**
     * 根据项目名查询项目信息
     */
    @PostMapping("/getInfoByName")
    public JSONObject getProjectMessageInfoByName(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName");
        return projectMessageService.getProjectMessageInfoByName(requestJson);
    }

    /**
     * 根据项目类型查询项目信息
     */
    @PostMapping("/getInfoByType")
    public JSONObject getProjectMessageInfoByType(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectType");
        return projectMessageService.getProjectMessageInfoByType(requestJson);
    }

    /**
     * 根据招标状态查询项目信息
     */
    @PostMapping("/getInfoByStatus")
    public JSONObject getProjectMessageInfoByStatus(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "tenderStatus");
        return projectMessageService.getProjectMessageInfoByStatus(requestJson);
    }

    /**
     * 根据项目角色查询项目信息
     */
    @PostMapping("/getInfoByRole")
    public JSONObject getProjectMessageInfoByRole(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "recruitmentRole");
        return projectMessageService.getProjectMessageInfoByRole(requestJson);
    }
}

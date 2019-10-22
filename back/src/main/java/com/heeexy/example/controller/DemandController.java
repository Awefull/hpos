package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.DemandService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wwq
 * @description: 发布需求controller
 * @date: 2019/3/24 17:50
 */
@RestController
@RequestMapping("/demand")
public class DemandController {

    @Autowired
    private DemandService demandService;

    @PostMapping("/releaseDemand")
    public JSONObject releaseDemand(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson,"unitName,projectName,projectDescription,demandType,projectCycle,projectBudget,recruitmentRole,projectDemand,projectType");
        return demandService.releaseDemand(requestJson);
    }

    public JSONObject participationProjectSuccess(JSONObject requestJson) {
        return demandService.participationProjectSuccess(requestJson);
    }
}

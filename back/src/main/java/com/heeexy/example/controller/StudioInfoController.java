package com.heeexy.example.controller;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.StudioInfoService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/studioInfo")
public class StudioInfoController {
    @Autowired
    private StudioInfoService studioInfoService;

    /**
     * 查询用户列表
     */
    @GetMapping("/listStudioInfo")
    public JSONObject listStudioInfo(HttpServletRequest request) {
        return studioInfoService.listStudioInfo(CommonUtil.request2Json(request));
    }

    /**
     * 查询用户信息
     */
    @PostMapping("/getStudioInfo")
    public JSONObject getStudioInfo(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName");
        return studioInfoService.getStudioInfo(requestJson);
    }

    /**
     * 过滤信息
     */
    @PostMapping("/filterStudio")
    public JSONObject filterStudio(@RequestBody JSONObject requestJson) {
        //对传入的alreadyServed的数字区间进行处理
        requestJson = analysisAlreadyServedStr(requestJson);
        //CommonUtil.hasAllRequired(requestJson, "projectType,servePlace,alreadyServed,orderBy");

        if (requestJson.getString("projectType").equals("全部") && !requestJson.getString("servePlace").equals("全部")) {
            if (requestJson.getString("orderBy").equals("需求指标评价优先"))
                return studioInfoService.filterServePlaceOrderByDemand(requestJson);
            else if (requestJson.getString("orderBy").equals("能力指标评价优先"))
                return studioInfoService.filterServePlaceOrderByAbility(requestJson);
            else if (requestJson.getString("orderBy").equals("计划指标评价优先"))
                return studioInfoService.filterServePlaceOrderByPlan(requestJson);
            else
                return studioInfoService.filterServePlace(requestJson);
        } else if (requestJson.getString("servePlace").equals("全部") && !requestJson.getString("projectType").equals("全部")) {
            if (requestJson.getString("orderBy").equals("需求指标评价优先"))
                return studioInfoService.filterProjectTypeOrderByDemand(requestJson);
            else if (requestJson.getString("orderBy").equals("能力指标评价优先"))
                return studioInfoService.filterProjectTypeOrderByAbility(requestJson);
            else if (requestJson.getString("orderBy").equals("计划指标评价优先"))
                return studioInfoService.filterProjectTypeOrderByPlan(requestJson);
            else
                return studioInfoService.filterProjectType(requestJson);
        } else if (requestJson.getString("servePlace").equals("全部") && requestJson.getString("projectType").equals("全部")) {
            if (requestJson.getString("orderBy").equals("需求指标评价优先"))
                return studioInfoService.getListStudioInfoOrderByDemand(requestJson);
            else if (requestJson.getString("orderBy").equals("能力指标评价优先"))
                return studioInfoService.getListStudioInfoOrderByAbility(requestJson);
            else if (requestJson.getString("orderBy").equals("计划指标评价优先"))
                return studioInfoService.getListStudioInfoOrderByPlan(requestJson);
            else
                return studioInfoService.getListStudioInfo(requestJson);
        } else{
            if (requestJson.getString("orderBy").equals("需求指标评价优先"))
                return studioInfoService.filterProjectTypeAndServePlaceOrderByDemand(requestJson);
            else if (requestJson.getString("orderBy").equals("能力指标评价优先"))
                return studioInfoService.filterProjectTypeAndServePlaceOrderByAbility(requestJson);
            else if (requestJson.getString("orderBy").equals("计划指标评价优先"))
                return studioInfoService.filterProjectTypeAndServePlaceOrderByPlan(requestJson);
            else
                return studioInfoService.filterProjectTypeAndServePlace(requestJson);
        }
    }

    public JSONObject analysisAlreadyServedStr(JSONObject requestJson) {
        if (requestJson.getString("alreadyServed").equals("200+")) {
            requestJson.remove("alreadyServed");
            requestJson.put("lowData",200);
            requestJson.put("heightData",2000);
            return requestJson;
        } else if(requestJson.getString("alreadyServed").equals("150-200")) {
            requestJson.remove("alreadyServed");
            requestJson.put("lowData",150);
            requestJson.put("heightData",200);
            return requestJson;
        } else if(requestJson.getString("alreadyServed").equals("100-150")) {
            requestJson.remove("alreadyServed");
            requestJson.put("lowData",100);
            requestJson.put("heightData",150);
            return requestJson;
        } else if(requestJson.getString("alreadyServed").equals("50-100")) {
            requestJson.remove("alreadyServed");
            requestJson.put("lowData",50);
            requestJson.put("heightData",100);
            return requestJson;
        } else if(requestJson.getString("alreadyServed").equals("20-50")) {
            requestJson.remove("alreadyServed");
            requestJson.put("lowData",20);
            requestJson.put("heightData",50);
            return requestJson;
        } else if(requestJson.getString("alreadyServed").equals("20以下")) {
            requestJson.remove("alreadyServed");
            requestJson.put("lowData",0);
            requestJson.put("heightData",20);
            return requestJson;
        }
        return requestJson;
    }
}

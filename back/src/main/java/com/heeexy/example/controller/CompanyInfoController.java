package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.CompanyInfoService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/companyInfo")
public class CompanyInfoController {
    @Autowired
    private CompanyInfoService companyInfoService;

    /**
     * 查询用户列表
     */
    @GetMapping("/listCompanyInfo")
    public JSONObject listCompanyInfo(HttpServletRequest request) {
        return companyInfoService.listCompanyInfo(CommonUtil.request2Json(request));
    }

    /**
     * 过滤信息
     */
    @PostMapping("/filterCompany")
    public JSONObject filterCompany(@RequestBody JSONObject requestJson) {

        if (requestJson.getString("projectType").equals("全部") && requestJson.getString("servePlace").equals("全部") && !requestJson.getString("serveRole").equals("全部")) {
            return companyInfoService.filterRole(requestJson);
        } else if (requestJson.getString("projectType").equals("全部") && !requestJson.getString("servePlace").equals("全部") && requestJson.getString("serveRole").equals("全部")) {
                return companyInfoService.filterServePlace(requestJson);
        } else if(!requestJson.getString("projectType").equals("全部") && requestJson.getString("servePlace").equals("全部") && requestJson.getString("serveRole").equals("全部")) {
                return companyInfoService.filterProjectType(requestJson);
        } else if(requestJson.getString("projectType").equals("全部") && requestJson.getString("servePlace").equals("全部") && requestJson.getString("serveRole").equals("全部")) {
            return companyInfoService.listCompanyInfo(requestJson);
        } else if(requestJson.getString("projectType").equals("全部") && !requestJson.getString("servePlace").equals("全部") && !requestJson.getString("serveRole").equals("全部")) {
            return companyInfoService.filterPlaceANDRole(requestJson);
        } else if(!requestJson.getString("projectType").equals("全部") && requestJson.getString("servePlace").equals("全部") && !requestJson.getString("serveRole").equals("全部")) {
            return companyInfoService.filterTypeANDRole(requestJson);
        } else if(!requestJson.getString("projectType").equals("全部") && !requestJson.getString("servePlace").equals("全部") && requestJson.getString("serveRole").equals("全部")) {
            return companyInfoService.filterPlaceANDType(requestJson);
        }
         else return companyInfoService.filterTypePlaceRole(requestJson);
    }

}

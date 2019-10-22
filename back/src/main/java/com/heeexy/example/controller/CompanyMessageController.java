package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.CompanyMessageService;
import com.heeexy.example.service.UserService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/companyMessage")
public class CompanyMessageController {
    @Autowired
    private CompanyMessageService companyMessageService;

    /**
     * 查询用户列表
     */
    @GetMapping("/listCompanyMessage")
    public JSONObject listCompanyMessage(HttpServletRequest request) {
        return companyMessageService.listCompanyMessage(CommonUtil.request2Json(request));
    }

    /**
     * 查询用户信息
     */
    @PostMapping("/getCompanyMessage")
    public JSONObject getCompanyMessage(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName");
        return companyMessageService.getCompanyMessage(requestJson);
    }

}

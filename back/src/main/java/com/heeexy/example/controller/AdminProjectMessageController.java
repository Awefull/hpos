package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.AdminProjectMessageService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Admin")
public class AdminProjectMessageController {

    @Autowired
    private AdminProjectMessageService AdminProjectMessageService;

    /**
     * 项目信息列表
     */
    @GetMapping("/getProjectMessagelist")
    public JSONObject listProjectMessage(HttpServletRequest request) {
        return AdminProjectMessageService.listProjectMessage(CommonUtil.request2Json(request));
    }
}

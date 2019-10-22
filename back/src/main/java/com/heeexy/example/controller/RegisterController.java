package com.heeexy.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.ClassifyService;
import com.heeexy.example.service.RegisterService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wwq
 * @description: 发布需求controller
 * @date: 2019/4/1 21:00
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public JSONObject register(@RequestBody JSONObject requestJson){

        CommonUtil.hasAllRequired(requestJson,"username,password,passwordAgain,email,address,telephone,roleId,unitName");
        return registerService.register(requestJson);
    }
}

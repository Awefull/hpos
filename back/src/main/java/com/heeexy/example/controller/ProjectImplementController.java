package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.ProjectImplementService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Implement")
public class ProjectImplementController {

    @Autowired
    private ProjectImplementService ProjectImplementService;

    /**
     * 查询项目日志到列表
     */
    @GetMapping("/getProgressLog")
    public JSONObject listProgressLog(HttpServletRequest request) {
        return ProjectImplementService.listProgressLog(CommonUtil.request2Json(request));
    }

    /**
     * 查询筛选项目日志到列表
     */
    @PostMapping("/FoundList")
    public JSONObject listFoundProgressLog(@RequestBody JSONObject requestJson) {
        return ProjectImplementService.listFoundProgressLog(requestJson);
    }
}

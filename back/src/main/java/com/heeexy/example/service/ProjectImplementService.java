package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface ProjectImplementService {

    /**
     * 查询项目日志到列表
     */
    JSONObject listProgressLog(JSONObject jsonObject);

    /**
     * 查询筛选的项目日志到列表
     */
    JSONObject listFoundProgressLog(JSONObject jsonObject);
}

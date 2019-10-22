package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface AdminProjectMessageService {

    /**
     * 项目信息列表
     */
    JSONObject listProjectMessage(JSONObject jsonObject);
}

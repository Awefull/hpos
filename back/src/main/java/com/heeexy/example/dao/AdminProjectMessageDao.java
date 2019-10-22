package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface AdminProjectMessageDao {
    /**
     * 查询项目信息数量
     */
    int countProjectMessage(JSONObject jsonObject);

    /**
     * 查询项目信息列表
     */
    List<JSONObject> listProjectMessage(JSONObject jsonObject);
}

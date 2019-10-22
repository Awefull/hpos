package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface ProjectImplementDao {

    /**
     * 查询日志条数
     */
    int countProgressLog(JSONObject jsonObject);

    /**
     * 查询项目日志列表
     */
    List<JSONObject> listProgressLog(JSONObject jsonObject);

    /**
     * 查询筛选的项目日志列表
     */
    List<JSONObject> listFoundProgressLog(JSONObject jsonObject);
}

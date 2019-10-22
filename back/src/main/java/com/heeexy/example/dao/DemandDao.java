package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface DemandDao {
    /**
     * 发布需求
     */
    int releaseDemand(JSONObject jsonObject);

    int participationProjectSuccess(JSONObject jsonObject);
}

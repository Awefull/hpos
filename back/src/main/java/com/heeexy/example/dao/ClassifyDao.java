package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface ClassifyDao {

    /**
     * 筛选项目
     */
    List<JSONObject> getAllDemand(JSONObject jsonObject);

    List<JSONObject> filterStatusAndRole(JSONObject jsonObject);

    List<JSONObject> filterTypeAndRole(JSONObject jsonObject);

    List<JSONObject> filterTypeAndStatus(JSONObject jsonObject);

    List<JSONObject> filterType(JSONObject jsonObject);

    List<JSONObject> filterStatus(JSONObject jsonObject);

    List<JSONObject> filterRole(JSONObject jsonObject);

    List<JSONObject> getDemandByProjectName(JSONObject jsonObject);

    JSONObject getDemandIdByProjectName(JSONObject jsonObject);

    int participationProject(JSONObject jsonObject);

    List<JSONObject> isAlreadyparticipated(JSONObject jsonObject);
}

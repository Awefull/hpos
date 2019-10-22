package com.heeexy.example.service;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: wwq
 * @description: 发布需求controller
 * @date: 2019/3/24 17:50
 */
public interface ClassifyService {
    /**
     * 筛选项目
     */
    JSONObject getAllDemand(JSONObject jsonObject);

    JSONObject filterStatusAndRole(JSONObject jsonObject);

    JSONObject filterTypeAndRole(JSONObject jsonObject);

    JSONObject filterTypeAndStatus(JSONObject jsonObject);

    JSONObject filterType(JSONObject jsonObject);

    JSONObject filterStatus(JSONObject jsonObject);

    JSONObject filterRole(JSONObject jsonObject);

    JSONObject getDemandByProjectName(JSONObject jsonObject);

    JSONObject getDemandIdByProjectName(JSONObject jsonObject);

    JSONObject participationProject(JSONObject jsonObject);

    List<JSONObject> isAlreadyparticipated(JSONObject jsonObject);
}

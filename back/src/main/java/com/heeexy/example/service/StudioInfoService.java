package com.heeexy.example.service;
import com.alibaba.fastjson.JSONObject;
public interface StudioInfoService {
    /**
     * 工作室列表
     */
    JSONObject listStudioInfo(JSONObject jsonObject);

    /**
     * 工作室信息
     */
    JSONObject getStudioInfo(JSONObject jsonObject);

    JSONObject filterServePlace(JSONObject jsonObject);

    JSONObject filterServePlaceOrderByDemand(JSONObject jsonObject);

    JSONObject filterServePlaceOrderByAbility(JSONObject jsonObject);

    JSONObject filterServePlaceOrderByPlan(JSONObject jsonObject);

    JSONObject filterProjectType(JSONObject jsonObject);

    JSONObject filterProjectTypeOrderByDemand(JSONObject jsonObject);

    JSONObject filterProjectTypeOrderByAbility(JSONObject jsonObject);

    JSONObject filterProjectTypeOrderByPlan(JSONObject jsonObject);

    JSONObject filterProjectTypeAndServePlace(JSONObject jsonObject);

    JSONObject filterProjectTypeAndServePlaceOrderByDemand(JSONObject jsonObject);

    JSONObject filterProjectTypeAndServePlaceOrderByAbility(JSONObject jsonObject);

    JSONObject filterProjectTypeAndServePlaceOrderByPlan(JSONObject jsonObject);

    JSONObject getListStudioInfo(JSONObject jsonObject);

    JSONObject getListStudioInfoOrderByDemand(JSONObject jsonObject);

    JSONObject getListStudioInfoOrderByAbility(JSONObject jsonObject);

    JSONObject getListStudioInfoOrderByPlan(JSONObject jsonObject);
}

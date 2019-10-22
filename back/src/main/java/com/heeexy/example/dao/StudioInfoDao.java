package com.heeexy.example.dao;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface StudioInfoDao {
    /**
     * 查询工作室数量
     */
    int countStudioInfo(JSONObject jsonObject);

    /**
     * 查询工作室信息列表
     */
    List<JSONObject> listStudioInfo(JSONObject jsonObject);

    /**
     * 查询工作室信息
     */
    JSONObject getStudioInfo(String unitName);

    List<JSONObject> filterServePlace(JSONObject jsonObject);

    List<JSONObject> filterServePlaceOrderByDemand(JSONObject jsonObject);

    List<JSONObject> filterServePlaceOrderByAbility(JSONObject jsonObject);

    List<JSONObject> filterServePlaceOrderByPlan(JSONObject jsonObject);

    List<JSONObject> filterProjectType(JSONObject jsonObject);

    List<JSONObject> filterProjectTypeOrderByDemand(JSONObject jsonObject);

    List<JSONObject> filterProjectTypeOrderByAbility(JSONObject jsonObject);

    List<JSONObject> filterProjectTypeOrderByPlan(JSONObject jsonObject);

    List<JSONObject> filterProjectTypeAndServePlace(JSONObject jsonObject);

    List<JSONObject> filterProjectTypeAndServePlaceOrderByDemand(JSONObject jsonObject);

    List<JSONObject> filterProjectTypeAndServePlaceOrderByAbility(JSONObject jsonObject);

    List<JSONObject> filterProjectTypeAndServePlaceOrderByPlan(JSONObject jsonObject);

    List<JSONObject> getListStudioInfo(JSONObject jsonObject);

    List<JSONObject> getListStudioInfoOrderByDemand(JSONObject jsonObject);

    List<JSONObject> getListStudioInfoOrderByAbility(JSONObject jsonObject);

    List<JSONObject> getListStudioInfoOrderByPlan(JSONObject jsonObject);
}

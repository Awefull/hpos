package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface CostManagementDao {

    /**
     * 查询支付情况信息数量
     */
    int countCostManagement(JSONObject jsonObject);

    /**
     * 查询支付情况到列表
     */
    List<JSONObject> listCostManagement(JSONObject jsonObject);

    /**
     * 更新定金支付完成的账户
     */
    int updateCostDeposit(JSONObject jsonObject);

    /**
     * 更新定金支付完成的账户
     */
    int updateCostFinal_payment(JSONObject jsonObject);
}

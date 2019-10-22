package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface CostManagementService {

    /**
     * 查询支付情况到列表
     */
    JSONObject listCostManagement(JSONObject jsonObject);

    /**
     * 更新定金支付完成的账户
     */
    JSONObject updateCostDeposit(JSONObject jsonObject);

    /**
     * 更新尾款支付完成的账户
     */
    JSONObject updateCostFinal_payment(JSONObject jsonObject);
}

package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

public interface TransactionService {
    /**
     * 用查询用户余额
     */
    JSONObject getBalance(JSONObject jsonObject);

    /**
     * 未完成交易数
     */
    JSONObject countCompletedTransactions(JSONObject jsonObject);

    JSONObject countOutstandingTransactions(JSONObject jsonObject);
}

package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface TransactionDao {

    /**
     * 查询企业用户余额
     */
    JSONObject getBalanceOfCompany(String unitName);

    /**
     * 查询工作室用户余额
     */
    JSONObject getBalanceOfStudio(String unitName);

    /**
     * 查询是否有完成记录
     */
    int isExistCompanyName(String unitName);

    /**
     * 查询是否有完成记录
     */
    int isExistStudioName(String unitName);

    /**
     * 已完成交易数
     */
    int countCompletedTransactionsOfStudio(String unitName);

    /**
     * 已完成交易表
     */
    List<JSONObject> completedTransactionsOfStudioList(String unitName);

    /**
     * 已完成交易数
     */
    int countCompletedTransactionsOfCompany(String unitName);

    /**
     * 已完成交易表
     */
    List<JSONObject> completedTransactionsOfCompanyList(String unitName);

    /**
     * 未完成交易数
     */
    JSONObject countOutstandingTransactionsOfStudio(String unitName);

    /**
     * 未完成交易数
     */
    JSONObject countOutstandingTransactionsOfCompany(String unitName);

    /**
     * 未完成交易表
     */
    List<JSONObject> outstandingTransactionsOfCompanyList1(String unitName);
    List<JSONObject> outstandingTransactionsOfCompanyList2(String unitName);

    /**
     * 未完成交易表
     */
    List<JSONObject> outstandingTransactionsOfStudioList1(String unitName);
    List<JSONObject> outstandingTransactionsOfStudioList2(String unitName);
}

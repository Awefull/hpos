package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface ExamineDao {

    /**
     * 查询企业用户数量
     */
    int countCompanyNotExamineAccount(JSONObject jsonObject);

    /**
     * 查询工作室用户数量
     */
    int countStudioNotExamineAccount(JSONObject jsonObject);

    /**
     * 查询广告位审核数量
     */
    int countAdvertisementNotExamine(JSONObject jsonObject);

    /**
     * 查询企业用户列表
     */
    List<JSONObject> listCompanyNotExamineAccount(JSONObject jsonObject);

    /**
     * 查询企业用户列表
     */
    List<JSONObject> listStudioNotExamineAccount(JSONObject jsonObject);

    /**
     * 查询广告位审核列表
     */
    List<JSONObject> listAdvertisementNotExamine(JSONObject jsonObject);

    /**
     * 更新审核通过的账户
     */
    int updateExamineAccount(JSONObject jsonObject);

    /**
     * 更新审核不通过的账户
     */
    int updateNoExamineAccount(JSONObject jsonObject);

    /**
     * 更新审核通过的广告位
     */
    int updateAdvertisementExamine(JSONObject jsonObject);

    /**
     * 更新审核不通过的广告位
     */
    int updateAdvertisementNoExamine(JSONObject jsonObject);
}

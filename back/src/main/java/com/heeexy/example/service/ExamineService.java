package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface ExamineService {

    /**
     * 查询企业用户到列表
     */
    JSONObject listCompanyNotExamineAccount(JSONObject jsonObject);

    /**
     * 查询工作室用户到列表
     */
    JSONObject listStudioNotExamineAccount(JSONObject jsonObject);

    /**
     * 查询广告审核到列表
     */
    JSONObject listAdvertisementNotExamine(JSONObject jsonObject);

    /**
     * 更新审核通过的账户
     */
    JSONObject updateExamineAccount(JSONObject jsonObject);

    /**
     * 更新审核不通过的账户
     */
    JSONObject updateNoExamineAccount(JSONObject jsonObject);

    /**
     * 更新审核通过的广告
     */
    JSONObject updateAdvertisementExamine(JSONObject jsonObject);

    /**
     * 更新审核不通过的广告
     */
    JSONObject updateAdvertisementNoExamine(JSONObject jsonObject);
}

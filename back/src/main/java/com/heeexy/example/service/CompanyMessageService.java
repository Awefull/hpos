package com.heeexy.example.service;
import com.alibaba.fastjson.JSONObject;

public interface CompanyMessageService {
    /**
     * 企业列表
     */
    JSONObject listCompanyMessage(JSONObject jsonObject);

    /**
     * 企业信息
     */
    JSONObject getCompanyMessage(JSONObject jsonObject);

}

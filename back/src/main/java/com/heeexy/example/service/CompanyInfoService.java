package com.heeexy.example.service;
import com.alibaba.fastjson.JSONObject;
public interface CompanyInfoService {
    /**
     * 工作室列表
     */
    JSONObject listCompanyInfo(JSONObject jsonObject);


    JSONObject filterServePlace(JSONObject jsonObject);

    JSONObject filterProjectType(JSONObject jsonObject);

    JSONObject filterRole(JSONObject jsonObject);

    JSONObject filterPlaceANDRole(JSONObject jsonObject);

    JSONObject filterTypeANDRole(JSONObject jsonObject);

    JSONObject filterPlaceANDType(JSONObject jsonObject);

    JSONObject filterTypePlaceRole(JSONObject jsonObject);

}

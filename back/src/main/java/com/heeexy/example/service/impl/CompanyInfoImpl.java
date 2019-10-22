package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.CompanyMessageDao;
import com.heeexy.example.dao.CompanyInfoDao;
import com.heeexy.example.service.CompanyInfoService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
@Service
public class CompanyInfoImpl implements CompanyInfoService {
    @Autowired
    private CompanyInfoDao companyInfoDao;
    /**
     * 项目列表
     */
    @Override
    public JSONObject listCompanyInfo(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = companyInfoDao.countCompanyInfo(jsonObject);
        List<JSONObject> list = companyInfoDao.listCompanyInfo(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }


    @Override
    public JSONObject filterServePlace(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = companyInfoDao.filterServePlace(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }


    @Override
    public JSONObject filterProjectType(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = companyInfoDao.filterProjectType(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }


    @Override
    public JSONObject filterRole(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = companyInfoDao.filterRole(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterTypeANDRole(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = companyInfoDao.filterTypeANDRole(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterPlaceANDRole(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = companyInfoDao.filterPlaceANDRole(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterPlaceANDType(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = companyInfoDao.filterPlaceANDType(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterTypePlaceRole(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = companyInfoDao.filterTypePlaceRole(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

}

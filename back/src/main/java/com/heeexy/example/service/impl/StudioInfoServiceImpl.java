package com.heeexy.example.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.CompanyMessageDao;
import com.heeexy.example.dao.StudioInfoDao;
import com.heeexy.example.service.StudioInfoService;
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
public class StudioInfoServiceImpl implements StudioInfoService {
    @Autowired
    private StudioInfoDao studioInfoDao;
    /**
     * 工作室列表
     */
    @Override
    public JSONObject listStudioInfo(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = studioInfoDao.countStudioInfo(jsonObject);
        List<JSONObject> list = studioInfoDao.listStudioInfo(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 查询工作室信息
     */
    @Override
    public JSONObject getStudioInfo(JSONObject jsonObject) {
        String unitName = jsonObject.getString("unitName");
        JSONObject info = new JSONObject();
        JSONObject jObject = studioInfoDao.getStudioInfo(unitName);
        info.put("companyMessageInfo", jObject);
        return CommonUtil.successJson(info);
    }

    @Override
    public JSONObject filterServePlace(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterServePlace(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterServePlaceOrderByDemand(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterServePlaceOrderByDemand(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterServePlaceOrderByAbility(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterServePlaceOrderByAbility(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterServePlaceOrderByPlan(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterServePlaceOrderByPlan(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterProjectType(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterProjectType(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterProjectTypeOrderByDemand(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterProjectTypeOrderByDemand(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterProjectTypeOrderByAbility(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterProjectTypeOrderByAbility(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterProjectTypeOrderByPlan(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterProjectTypeOrderByPlan(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterProjectTypeAndServePlace(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterProjectTypeAndServePlace(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterProjectTypeAndServePlaceOrderByDemand(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterProjectTypeAndServePlaceOrderByDemand(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterProjectTypeAndServePlaceOrderByAbility(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterProjectTypeAndServePlaceOrderByAbility(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject filterProjectTypeAndServePlaceOrderByPlan(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.filterProjectTypeAndServePlaceOrderByPlan(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject getListStudioInfo(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.getListStudioInfo(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject getListStudioInfoOrderByDemand(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.getListStudioInfoOrderByDemand(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject getListStudioInfoOrderByAbility(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.getListStudioInfoOrderByAbility(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    public JSONObject getListStudioInfoOrderByPlan(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = studioInfoDao.getListStudioInfoOrderByPlan(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }
}

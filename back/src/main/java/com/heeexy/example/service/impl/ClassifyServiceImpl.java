package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.ClassifyDao;
import com.heeexy.example.dao.DemandDao;
import com.heeexy.example.service.ClassifyService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyDao classifyDao;
    /**
     * 文章列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject getAllDemand(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = classifyDao.getAllDemand(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject filterStatusAndRole(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = classifyDao.filterStatusAndRole(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject filterTypeAndRole(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = classifyDao.filterTypeAndRole(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject filterTypeAndStatus(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = classifyDao.filterTypeAndStatus(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject filterType(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = classifyDao.filterType(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject filterStatus(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = classifyDao.filterStatus(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject filterRole(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = classifyDao.filterRole(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject getDemandByProjectName(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = classifyDao.getDemandByProjectName(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject getDemandIdByProjectName(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        JSONObject id = classifyDao.getDemandIdByProjectName(jsonObject);
        return CommonUtil.successPage(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject participationProject(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        classifyDao.participationProject(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public List<JSONObject> isAlreadyparticipated(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        return  classifyDao.isAlreadyparticipated(jsonObject);
    }

}

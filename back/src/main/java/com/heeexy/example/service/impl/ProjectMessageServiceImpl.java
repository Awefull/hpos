package com.heeexy.example.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.ProjectMessageDao;
import com.heeexy.example.service.ProjectMessageService;
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
public class ProjectMessageServiceImpl implements ProjectMessageService{
    @Autowired
    private ProjectMessageDao projectMessageDao;
    /**
     * 项目信息列表
     */
    @Override
    public JSONObject listProjectMessage(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = projectMessageDao.countProjectMessage(jsonObject);
        List<JSONObject> list = projectMessageDao.listProjectMessage(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 根据项目名查询项目信息
     */
    @Override
    public JSONObject getProjectMessageInfoByName(JSONObject jsonObject) {
        String unitName = jsonObject.getString("unitName");
        JSONObject info = new JSONObject();
        JSONObject jObject = projectMessageDao.getProjectMessageInfoByName(unitName);
        info.put("projectMessageInfo", jObject);
        return CommonUtil.successJson(info);
    }

    /**
     * 根据项目类型查询项目信息
     */
    @Override
    public JSONObject getProjectMessageInfoByType(JSONObject jsonObject) {
        String unitName = jsonObject.getString("projectType");
        JSONObject info = new JSONObject();
        JSONObject jObject = projectMessageDao.getProjectMessageInfoByName(unitName);
        info.put("projectMessageInfo", jObject);
        return CommonUtil.successJson(info);
    }

    /**
     * 根据招标状态查询项目信息
     */
    @Override
    public JSONObject getProjectMessageInfoByStatus(JSONObject jsonObject) {
        String unitName = jsonObject.getString("tenderStatus");
        JSONObject info = new JSONObject();
        JSONObject jObject = projectMessageDao.getProjectMessageInfoByName(unitName);
        info.put("projectMessageInfo", jObject);
        return CommonUtil.successJson(info);
    }

    /**
     * 根据项目角色查询项目信息
     */
    @Override
    public JSONObject getProjectMessageInfoByRole(JSONObject jsonObject) {
        String unitName = jsonObject.getString("recruitmentRole");
        JSONObject info = new JSONObject();
        JSONObject jObject = projectMessageDao.getProjectMessageInfoByName(unitName);
        info.put("projectMessageInfo", jObject);
        return CommonUtil.successJson(info);
    }
}

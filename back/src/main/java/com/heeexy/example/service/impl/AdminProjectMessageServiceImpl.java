package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.AdminProjectMessageDao;
import com.heeexy.example.service.AdminProjectMessageService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProjectMessageServiceImpl implements AdminProjectMessageService {
    @Autowired
    private AdminProjectMessageDao AdminProjectMessageDao;
    /**
     * 项目信息列表
     */
    @Override
    public JSONObject listProjectMessage(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = AdminProjectMessageDao.countProjectMessage(jsonObject);
        List<JSONObject> list = AdminProjectMessageDao.listProjectMessage(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
}

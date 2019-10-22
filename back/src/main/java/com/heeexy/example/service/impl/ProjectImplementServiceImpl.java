package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.ProjectImplementDao;
import com.heeexy.example.service.ProjectImplementService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectImplementServiceImpl implements ProjectImplementService {
    @Autowired
    private ProjectImplementDao ProjectImplementDao;

    /**
     * 查询项目日志到列表
     */
    @Override
    public JSONObject listProgressLog(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = ProjectImplementDao.countProgressLog(jsonObject);
        List<JSONObject> list = ProjectImplementDao.listProgressLog(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 查询筛选的项目日志到列表
     */
    @Override
    public JSONObject listFoundProgressLog(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = ProjectImplementDao.countProgressLog(jsonObject);
        List<JSONObject> list = ProjectImplementDao.listFoundProgressLog(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
}

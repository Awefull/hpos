package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.ExamineDao;
import com.heeexy.example.service.ExamineService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {
    @Autowired
    private ExamineDao ExamineDao;

    /**
     * 查询企业用户到列表
     */
    @Override
    public JSONObject listCompanyNotExamineAccount(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = ExamineDao.countCompanyNotExamineAccount(jsonObject);
        List<JSONObject> list = ExamineDao.listCompanyNotExamineAccount(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 查询企业用户到列表
     */
    @Override
    public JSONObject listStudioNotExamineAccount(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = ExamineDao.countStudioNotExamineAccount(jsonObject);
        List<JSONObject> list = ExamineDao.listStudioNotExamineAccount(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 查询广告审核到列表
     */
    @Override
    public JSONObject listAdvertisementNotExamine(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = ExamineDao.countAdvertisementNotExamine(jsonObject);
        List<JSONObject> list = ExamineDao.listAdvertisementNotExamine(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 更新审核通过的账户
     */
    @Override
    public JSONObject updateExamineAccount(JSONObject jsonObject) {
        ExamineDao.updateExamineAccount(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 更新审核不通过的账户
     */
    @Override
    public JSONObject updateNoExamineAccount(JSONObject jsonObject) {
        ExamineDao.updateNoExamineAccount(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 更新审核通过的广告
     */
    @Override
    public JSONObject updateAdvertisementExamine(JSONObject jsonObject) {
        ExamineDao.updateAdvertisementExamine(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 更新审核不通过的广告
     */
    @Override
    public JSONObject updateAdvertisementNoExamine(JSONObject jsonObject) {
        ExamineDao.updateAdvertisementNoExamine(jsonObject);
        return CommonUtil.successJson();
    }
}

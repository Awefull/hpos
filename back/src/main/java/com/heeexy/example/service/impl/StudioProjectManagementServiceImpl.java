package com.heeexy.example.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.StudioProjectManagementDao;
import com.heeexy.example.service.StudioProjectManagementService;
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
public class StudioProjectManagementServiceImpl implements StudioProjectManagementService {
    @Autowired
    private StudioProjectManagementDao studioProjectManagementDao;
    /**
     * 招标中项目列表
     */
    @Override
    public JSONObject listStudioNotRecruited(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = studioProjectManagementDao.countStudioNotRecruited(jsonObject);
        List<JSONObject> list = studioProjectManagementDao.listStudioNotRecruited(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 更新未被募的工作室中的招募状态
     */
    @Override
    public JSONObject updateNotRecruitedBidStatus(JSONObject jsonObject) {
        studioProjectManagementDao.updateNotRecruitedBidStatus(jsonObject);
        studioProjectManagementDao.updateRecruitedBidStatus(jsonObject);
        return CommonUtil.successJson();
    }
    /**
     * 删除进行中的某项目
     */
    @Override
    public JSONObject deleteStudioProgress(JSONObject jsonObject) {
        studioProjectManagementDao.deleteStudioProgress(jsonObject);
        studioProjectManagementDao.deleteStudioNotRecruited(jsonObject);
        return CommonUtil.successJson();
    }


    /**
     * 添加招标中项目
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addStudioNotRecruited(JSONObject jsonObject) {
        studioProjectManagementDao.addStudioNotRecruited(jsonObject);
        return CommonUtil.successJson();
    }
    /**
     * 更新招标中列表中的项目
     */
    @Override
    public JSONObject updateNotRecruitedProject(JSONObject jsonObject) {
        studioProjectManagementDao.updateNotRecruitedProject(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 进行中项目列表
     */
    @Override
    public JSONObject listStudioProgress(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = studioProjectManagementDao.countStudioProgress(jsonObject);
        List<JSONObject> list = studioProjectManagementDao.listStudioProgress(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 添加进行中项目
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addStudioProgress(JSONObject jsonObject) {
        studioProjectManagementDao.addStudioProgress(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 添加进度
     */
    @Override
    public JSONObject addLog(JSONObject jsonObject) {
        studioProjectManagementDao.addLog(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 查询某项目的日志
     */
    @Override
    public JSONObject getProjectProgressLog(JSONObject jsonObject) {
        String studioName = jsonObject.getString("studioName");
        String projectName = jsonObject.getString("projectName");
        List<JSONObject> list = studioProjectManagementDao.getProjectProgressLog(studioName, projectName);
        int count = list.size();
        return CommonUtil.successPage(list, count);
    }

    /**
     * 修改进行中项目
     */
    @Override
    public JSONObject updateStudioProgress(JSONObject jsonObject) {
        studioProjectManagementDao.updateStudioProgress(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 已完成项目列表
     */
    @Override
    public JSONObject listStudioFinished(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = studioProjectManagementDao.countStudioFinished(jsonObject);
        List<JSONObject> list = studioProjectManagementDao.listStudioFinished(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 添加已完成项目
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addStudioFinished(JSONObject jsonObject) {
        studioProjectManagementDao.addStudioFinished(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 更新完成列表中的项目
     */
    @Override
    public JSONObject updateFinishedProject(JSONObject jsonObject) {
        studioProjectManagementDao.updateFinishedProject(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 工作室已完成项目数量
     */
    @Override
    public JSONObject countProjectNum(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = studioProjectManagementDao.countProjectNum(jsonObject);
        return CommonUtil.successPage(count);
    }
}

package com.heeexy.example.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.CompanyProjectManagementDao;
import com.heeexy.example.dao.UserDao;
import com.heeexy.example.service.CompanyProjectManagementService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyProjectManagementServicelmpl implements CompanyProjectManagementService {
    @Autowired
    private CompanyProjectManagementDao companyProjectManagementDao;
    @Autowired
    private UserDao userDao;


    /**
     * 增加项目到招募列表
     */
    @Override
    public JSONObject addNotRecruitedProject(JSONObject jsonObject) {
        companyProjectManagementDao.addNotRecruitedProject(jsonObject);
        return CommonUtil.successJson();
    }
    /**
     * 未招标项目列表
     */
    @Override
    public JSONObject listCompanyProjectNotRecruited(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = companyProjectManagementDao.countCompanyProjectNotRecruited(jsonObject);
        List<JSONObject> list = companyProjectManagementDao.listCompanyProjectNotRecruited(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 查询招募工作室列表
     */
    @Override
    public JSONObject getRecruiteList(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int tenderStatus = jsonObject.getInteger("tenderStatus");
        List<JSONObject> list = new ArrayList<JSONObject>();
        if (tenderStatus == 1) {
            list = companyProjectManagementDao.getRecruitedStudio(jsonObject);
            List<JSONObject> list1 = companyProjectManagementDao.getRecruitedList(jsonObject);
            list.addAll(list1);
        } else {
            list = companyProjectManagementDao.getRecruiteList(jsonObject);
        }
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    /**
     * 查询招募工作室列表
     */
    @Override
    public JSONObject getRecruitedList(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        List<JSONObject> list = companyProjectManagementDao.getRecruitedList(jsonObject);
        return CommonUtil.successPage(jsonObject, list, list.size());
    }

    /**
     * 更新未招募列表中的项目
     */
    @Override
    public JSONObject updateNotRecruitedProject(JSONObject jsonObject) {
        companyProjectManagementDao.updateNotRecruitedProject(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 增加项目到进行列表
     */
    @Override
    public JSONObject addProgressList(JSONObject jsonObject) {
        companyProjectManagementDao.addProgressList(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 更新进行列表中的项目
     */
    @Override
    public JSONObject updateProgressProject(JSONObject jsonObject) {
        companyProjectManagementDao.updateProgressProject(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 申请支付尾款
     */
    @Override
    public JSONObject applyForFinalPayment(JSONObject jsonObject) {
        String companyName = jsonObject.getString("companyName");
        String projectName = jsonObject.getString("projectName");
        String studioName = jsonObject.getString("studioName");
        companyProjectManagementDao.applyForFinalPayment(jsonObject);
        companyProjectManagementDao.updateProgressProjectApplyForPayment(companyName,projectName,studioName);
        return CommonUtil.successJson();
    }

    /**
     * 进行中项目列表
     */
    @Override
    public JSONObject listCompanyProjectProgress(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = companyProjectManagementDao.countCompanyProjectProgress(jsonObject);
        List<JSONObject> list = companyProjectManagementDao.listCompanyProjectProgress(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 查询某项目的日志
     */
    @Override
    public JSONObject getProjectProgressLog(JSONObject jsonObject) {
        String companyName = jsonObject.getString("companyName");
        String projectName = jsonObject.getString("projectName");
        List<JSONObject> list = companyProjectManagementDao.getProjectProgressLog(companyName, projectName);
        int count = list.size();
        return CommonUtil.successPage(list, count);
    }

    /**
     * 查询某项目的申请消息
     */
    @Override
    public JSONObject getApplyList(JSONObject jsonObject) {
        String companyName = jsonObject.getString("companyName");
        String projectName = jsonObject.getString("projectName");
        String studioName = jsonObject.getString("studioName");
        List<JSONObject> list = companyProjectManagementDao.getApplyList(jsonObject);
        companyProjectManagementDao.update2ProgressProjectApplyForPayment(companyName,projectName,studioName);
        int count = list.size();
        return CommonUtil.successPage(list, count);
    }

    /**
     * 增加项目到完成列表
     */
    @Override
    public JSONObject addFinishedList(JSONObject jsonObject) {
        String companyName = jsonObject.getString("companyName");
        String projectName = jsonObject.getString("projectName");
        String studioName = jsonObject.getString("studioName");
        float evaluate = jsonObject.getFloat("evaluate");
        float evaluateDemand = jsonObject.getFloat("evaluateDemand");
        float evaluateAbility = jsonObject.getFloat("evaluateAbility");
        float evaluatePlan = jsonObject.getFloat("evaluatePlan");
        companyProjectManagementDao.addFinishedList(jsonObject);
        companyProjectManagementDao.updateFinishedProjectEvaluate(companyName, projectName, studioName,evaluate,evaluateDemand,evaluateAbility,evaluatePlan);
        companyProjectManagementDao.updateFinishedProjectBudget(companyName, projectName, studioName);
        userDao.updateEvaluate(studioName, evaluate,evaluateDemand,evaluateAbility,evaluatePlan);
        return CommonUtil.successJson();
    }

    /**
     * 更新完成列表中的项目
     */
    @Override
    public JSONObject updateFinishedProject(JSONObject jsonObject) {
        companyProjectManagementDao.updateFinishedProject(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 完成的项目列表
     */
    @Override
    public JSONObject listCompanyProjectFinished(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = companyProjectManagementDao.countCompanyProjectFinished(jsonObject);
        List<JSONObject> list = companyProjectManagementDao.listCompanyProjectFinished(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject participationProjectSuccess(JSONObject jsonObject) {
        companyProjectManagementDao.participationProjectSuccess(jsonObject);
        return CommonUtil.successJson();
    }
}

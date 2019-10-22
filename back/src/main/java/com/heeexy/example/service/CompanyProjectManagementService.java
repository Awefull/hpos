package com.heeexy.example.service;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
@Service
public interface CompanyProjectManagementService {

    /**
     * 增加项目到招募列表
     */
    JSONObject addNotRecruitedProject(JSONObject jsonObject);

    /**
     * 招标中项目列表
     */
    JSONObject listCompanyProjectNotRecruited(JSONObject jsonObject);

    /**
     * 查询招募工作室列表
     */
    JSONObject getRecruiteList(JSONObject jsonObject);
    /**
     * 查询招募工作室列表
     */
    JSONObject getRecruitedList(JSONObject jsonObject);

    /**
     * 更新未招募列表中的项目
     */
    JSONObject updateNotRecruitedProject(JSONObject jsonObject);

    /**
     * 增加项目到进行列表
     */
    JSONObject addProgressList(JSONObject jsonObject);

    /**
     * 更新进行列表中的项目
     */
    JSONObject updateProgressProject(JSONObject jsonObject);

    /**
     * 申请支付尾款
     */
    JSONObject applyForFinalPayment(JSONObject jsonObject);

    /**
     * 进行中项目列表
     */
    JSONObject listCompanyProjectProgress(JSONObject jsonObject);

    /**
     * 查询某项目的日志
     */
    JSONObject getProjectProgressLog(JSONObject jsonObject);

    /**
     * 查询某项目的申请消息
     */
    JSONObject getApplyList(JSONObject jsonObject);

    /**
     * 增加项目到完成列表
     */
    JSONObject addFinishedList(JSONObject jsonObject);

    /**
     * 更新完成列表中的项目
     */
    JSONObject updateFinishedProject(JSONObject jsonObject);

    /**
     * 完成的项目列表
     */
    JSONObject listCompanyProjectFinished(JSONObject jsonObject);

    /**
     * 更新参与人数
     */
    JSONObject participationProjectSuccess(JSONObject jsonObject);
}

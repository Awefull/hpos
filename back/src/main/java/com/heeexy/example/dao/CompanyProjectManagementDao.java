package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 企业项目为招标状态
 */

public interface CompanyProjectManagementDao {

    /**
     * 增加项目到进行列表
     */
    int addNotRecruitedProject(JSONObject jsonObject);
    /**
     * 查询未招募项目数量
     */
    int countCompanyProjectNotRecruited(JSONObject jsonObject);

    /**
     * 更新未招募列表中的项目
     */
    int updateNotRecruitedProject(JSONObject jsonObject);

    /**
     * 查询未招募项目列表
     */
    List<JSONObject> listCompanyProjectNotRecruited(JSONObject jsonObject);

    /**
     * 增加项目到进行列表
     */
    int addProgressList(JSONObject jsonObject);


    /**
     * 查询进行中项目数量
     */
    int countCompanyProjectProgress(JSONObject jsonObject);

    /**
     * 增加项目到进行列表
     */
    int addFinishedList(JSONObject jsonObject);

    /**
     * 更新进行列表中的项目
     */
    int updateProgressProject(JSONObject jsonObject);

    int updateProgressProjectApplyForPayment(@Param("companyName") String companyName,@Param("projectName")String projectName,@Param("studioName") String studioName);
    int update2ProgressProjectApplyForPayment(@Param("companyName") String companyName,@Param("projectName")String projectName,@Param("studioName") String studioName);
    /**
     * 申请支付尾款
     */
    int applyForFinalPayment(JSONObject jsonObject);

    /**
     * 查询进行项目列表
     */
    List<JSONObject> listCompanyProjectProgress(JSONObject jsonObject);


    /**
     * 查询招募工作室列表
     */
    List<JSONObject> getRecruiteList(JSONObject jsonObject);

    /**
     * 查询招募工作室列表
     */
    List<JSONObject> getRecruitedList(JSONObject jsonObject);
    List<JSONObject> getRecruitedStudio(JSONObject jsonObject);

    /**
     * 查询某项目的日志
     */
    List<JSONObject> getProjectProgressLog(@Param("companyName") String companyName,@Param("projectName")String projectName);

    /**
     * 查询某项目的申请消息
     */
    List<JSONObject> getApplyList(JSONObject jsonObject);
    /**
     * 查询完成的项目数量
     */
    int countCompanyProjectFinished(JSONObject jsonObject);

    /**
     * 更新完成列表中的项目
     */
    int updateFinishedProject(JSONObject jsonObject);
    int updateFinishedProjectEvaluate(@Param("companyName")String companyName, @Param("projectName")String projectName,@Param("studioName")String studioName,@Param("evaluate")float evaluate, @Param("evaluateDemand")float evaluateDemand,@Param("evaluateAbility")float evaluateAbility,@Param("evaluatePlan")float evaluatePlan);
    int updateFinishedProjectBudget(@Param("companyName")String companyName, @Param("projectName")String projectName, @Param("studioName")String studioName);


    /**
     * 查询完成的项目列表
     */
    List<JSONObject> listCompanyProjectFinished(JSONObject jsonObject);


    int participationProjectSuccess(JSONObject jsonObject);
}

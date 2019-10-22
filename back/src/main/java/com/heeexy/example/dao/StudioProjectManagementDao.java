package com.heeexy.example.dao;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author: cq
 * @description: 工作室/招标中
 * @date: 2019-3-24 20:45
 */

public interface StudioProjectManagementDao {
    /**
     * 查询招标中项目数量
     */
    int countStudioNotRecruited(JSONObject jsonObject);

    /**
     * 更新未被募的工作室中的招募状态
     */
    int updateNotRecruitedBidStatus(JSONObject jsonObject);
    /**
     * 更新被募的工作室中的招募状态
     */
    int updateRecruitedBidStatus(JSONObject jsonObject);



    /**
     * 查询招标中项目列表
     */
    List<JSONObject> listStudioNotRecruited(JSONObject jsonObject);

    /**
     * 新增招标中项目
     */
    int addStudioNotRecruited(JSONObject jsonObject);

    /**
     * 更新未招募列表中的项目
     */
    int updateNotRecruitedProject(JSONObject jsonObject);

    /**
     * 删除进行中的某项目
     */
    int deleteStudioProgress(JSONObject jsonObject);
    int deleteStudioNotRecruited(JSONObject jsonObject);

    /**
     * 查询进行中项目数量
     */
    int countStudioProgress(JSONObject jsonObject);

    /**
     * 查询某项目的日志
     */
    List<JSONObject> getProjectProgressLog(@Param("studioName") String studioName,@Param("projectName")String projectName);

    /**
     * 查询进行中项目列表
     */
    List<JSONObject> listStudioProgress(JSONObject jsonObject);
    /**
     * 新增进行中项目
     */
    int addStudioProgress(JSONObject jsonObject);

    /**
     * 新增进度
     */
    int addLog(JSONObject jsonObject);
    /**
     * 更新进行中的项目
     */
    int updateStudioProgress(JSONObject jsonObject);

    /**
     * 查询已结束项目数量
     */
    int countStudioFinished(JSONObject jsonObject);

    /**
     * 查询已结束项目列表
     */
    List<JSONObject> listStudioFinished(JSONObject jsonObject);
    /**
     * 新增已结束项目
     */
    int addStudioFinished(JSONObject jsonObject);

    /**
     * 更新完成列表中的项目
     */
    int updateFinishedProject(JSONObject jsonObject);
    /**
     * 查询某工作室完成项目数量
     */
    int countProjectNum(JSONObject jsonObject);
}

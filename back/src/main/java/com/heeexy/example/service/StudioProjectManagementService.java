package com.heeexy.example.service;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
@Service
public interface StudioProjectManagementService {
    /**
     * 招标中项目列表
     */
    JSONObject listStudioNotRecruited(JSONObject jsonObject);

    /**
     * 更新未被募的工作室中的招募状态
     */
    JSONObject updateNotRecruitedBidStatus(JSONObject jsonObject);

    /**
     * 删除进行中的某项目
     */
    JSONObject deleteStudioProgress(JSONObject jsonObject);


    /**
     * 添加招标中项目
     */
    JSONObject addStudioNotRecruited(JSONObject jsonObject);

    /**
     * 更新未招募列表中的项目
     */
    JSONObject updateNotRecruitedProject(JSONObject jsonObject);

    /**
     * 进行中项目列表
     */
    JSONObject listStudioProgress(JSONObject jsonObject);
    /**
     * 添加进行中项目
     */
    JSONObject addStudioProgress(JSONObject jsonObject);

    /**
     * 查询某项目的日志
     */
    JSONObject getProjectProgressLog(JSONObject jsonObject);

    /**
     * 添加进行中项目
     */
    JSONObject addLog(JSONObject jsonObject);

    /**
     * 修改用户
     */
    JSONObject updateStudioProgress(JSONObject jsonObject);

    /**
     * 已完成项目列表
     */
    JSONObject listStudioFinished(JSONObject jsonObject);
    /**
     * 添加已完成项目
     */
    JSONObject addStudioFinished(JSONObject jsonObject);

    /**
     * 更新完成列表中的项目
     */
    JSONObject updateFinishedProject(JSONObject jsonObject);
    /**
     * 工作室已完成项目数量
     */
    JSONObject countProjectNum(JSONObject jsonObject);
}

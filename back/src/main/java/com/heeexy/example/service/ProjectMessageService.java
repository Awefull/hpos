package com.heeexy.example.service;
import com.alibaba.fastjson.JSONObject;

public interface ProjectMessageService {
    /**
     * 项目信息列表
     */
    JSONObject listProjectMessage(JSONObject jsonObject);

    /**
     * 根据项目名查询项目信息
     */
    JSONObject getProjectMessageInfoByName(JSONObject jsonObject);

    /**
     * 根据项目类型查询项目信息
     */
    JSONObject getProjectMessageInfoByType(JSONObject jsonObject);

    /**
     * 根据招标状态查询项目信息
     */
    JSONObject getProjectMessageInfoByStatus(JSONObject jsonObject);

    /**
     * 根据项目角色查询项目信息
     */
    JSONObject getProjectMessageInfoByRole(JSONObject jsonObject);
}

package com.heeexy.example.dao;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author: cq
 * @description: 项目/信息
 * @date: 2019-3-27 21:17:45
 */
public interface ProjectMessageDao {
    /**
     * 查询项目信息数量
     */
    int countProjectMessage(JSONObject jsonObject);

    /**
     * 查询项目信息列表
     */
    List<JSONObject> listProjectMessage(JSONObject jsonObject);

    /**
     * 根据项目名查询项目信息
     */
    JSONObject getProjectMessageInfoByName(String unitName);
    /**
     * 根据项目类型查询项目信息
     */
    JSONObject getProjectMessageInfoByType(String projectType);
    /**
     * 根据招标状态查询项目信息
     */
    JSONObject getProjectMessageInfoByStatus(String tenderStatus);
    /**
     * 根据项目角色查询项目信息
     */
    JSONObject getProjectMessageInfoByRole(String recruitmentRole);

}

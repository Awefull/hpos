package com.heeexy.example.dao;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CompanyMessageDao {
    /**
     * 查询企业信息数量
     */
    int countCompanyMessage(JSONObject jsonObject);

    /**
     * 查询企业信息列表
     */
    List<JSONObject> listCompanyMessage(JSONObject jsonObject);

    /**
     * 查询企业信息
     */
    JSONObject getCompanyMessage(String unitName);
}

package com.heeexy.example.dao;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface CompanyInfoDao {
    /**
     * 查询工作室数量
     */
    int countCompanyInfo(JSONObject jsonObject);

    /**
     * 查询工作室信息列表
     */
    List<JSONObject> listCompanyInfo(JSONObject jsonObject);

    List<JSONObject> filterServePlace(JSONObject jsonObject);

    List<JSONObject> filterProjectType(JSONObject jsonObject);

    List<JSONObject> filterRole(JSONObject jsonObject);

    List<JSONObject> filterPlaceANDRole(JSONObject jsonObject);

    List<JSONObject> filterTypeANDRole(JSONObject jsonObject);

    List<JSONObject> filterPlaceANDType(JSONObject jsonObject);


    List<JSONObject> filterTypePlaceRole(JSONObject jsonObject);
}

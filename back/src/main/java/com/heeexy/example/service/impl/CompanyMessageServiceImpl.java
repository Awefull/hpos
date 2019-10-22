package com.heeexy.example.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.CompanyMessageDao;
import com.heeexy.example.dao.StudioProjectManagementDao;
import com.heeexy.example.service.CompanyMessageService;
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

public class CompanyMessageServiceImpl implements CompanyMessageService {
    @Autowired
    private CompanyMessageDao companyMessageDao;
    /**
     * 招标中项目列表
     */
    @Override
    public JSONObject listCompanyMessage(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = companyMessageDao.countCompanyMessage(jsonObject);
        List<JSONObject> list = companyMessageDao.listCompanyMessage(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 查询企业信息
     */
    @Override
    public JSONObject getCompanyMessage(JSONObject jsonObject) {
        String unitName = jsonObject.getString("unitName");
        JSONObject info = new JSONObject();
        JSONObject jObject = companyMessageDao.getCompanyMessage(unitName);
        info.put("companyMessageInfo", jObject);
        return CommonUtil.successJson(info);
    }
}

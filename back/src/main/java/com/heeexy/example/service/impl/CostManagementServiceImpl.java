package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.CostManagementDao;
import com.heeexy.example.service.CostManagementService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostManagementServiceImpl implements CostManagementService {
    @Autowired
    private CostManagementDao CostManagementDao;

    /**
     * 查询支付情况到列表
     */
    @Override
    public JSONObject listCostManagement(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = CostManagementDao.countCostManagement(jsonObject);
        List<JSONObject> list = CostManagementDao.listCostManagement(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    /**
     * 更新定金支付完成的账户
     */
    @Override
    public JSONObject updateCostDeposit(JSONObject jsonObject) {
        CostManagementDao.updateCostDeposit(jsonObject);
        return CommonUtil.successJson();
    }

    /**
     * 更新尾款支付完成的账户
     */
    @Override
    public JSONObject updateCostFinal_payment(JSONObject jsonObject) {
        CostManagementDao.updateCostFinal_payment(jsonObject);
        return CommonUtil.successJson();
    }
}

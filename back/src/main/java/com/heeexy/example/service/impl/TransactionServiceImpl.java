package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.TransactionDao;
import com.heeexy.example.service.TransactionService;
import com.heeexy.example.service.UserService;
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
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDao transactionDao;

    /**
     * 查用查询用户余额
     */
    @Override
    public JSONObject getBalance(JSONObject jsonObject) {
        String unitName = jsonObject.getString("unitName");
        int roleId = jsonObject.getInteger("roleId");
        JSONObject info = new JSONObject();
        if (roleId == 2) {
            JSONObject jObject = transactionDao.getBalanceOfStudio(unitName);
            info.put("balance", jObject);
        }
        else if (roleId == 3) {
            JSONObject jObject = transactionDao.getBalanceOfCompany(unitName);
            info.put("balance", jObject);
        }
        return CommonUtil.successJson(info);
    }

    /**
     * 已完成交易数
     */
    @Override
    public JSONObject countCompletedTransactions(JSONObject jsonObject) {
        String unitName = jsonObject.getString("unitName");
        int roleId = jsonObject.getInteger("roleId");
        List<JSONObject> list = new ArrayList<>();
        if (roleId == 2) {
            list = transactionDao.completedTransactionsOfStudioList(unitName);
        }
        else if (roleId == 3) {
            list = transactionDao.completedTransactionsOfCompanyList(unitName);
        }
        return CommonUtil.successPage(list,list.size());
    }

    /**
     * 未完成交易数
     */
    @Override
    public JSONObject countOutstandingTransactions(JSONObject jsonObject) {
        String unitName = jsonObject.getString("unitName");
        int roleId = jsonObject.getInteger("roleId");
        List<JSONObject> list1 = new ArrayList<>();
        List<JSONObject> list2 = new ArrayList<>();
        if (roleId == 2) {
            list1 = transactionDao.outstandingTransactionsOfStudioList1(unitName);
            list2 = transactionDao.outstandingTransactionsOfStudioList2(unitName);
            list1.addAll(list2);
        }
        else if (roleId == 3) {
            list1 = transactionDao.outstandingTransactionsOfCompanyList1(unitName);
            list2 = transactionDao.outstandingTransactionsOfCompanyList2(unitName);
            list1.addAll(list2);
        }
        return CommonUtil.successPage(list1,list1.size());
    }
}

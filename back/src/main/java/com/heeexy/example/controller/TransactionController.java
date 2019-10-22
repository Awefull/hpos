package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.TransactionService;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    /**
     * 查询用户余额
     */
    @PostMapping("/getBalance")
    public JSONObject getBalance(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName, roleId");
        return transactionService.getBalance(requestJson);
    }

    /**
     * 已完成交易数
     */
    @PostMapping("/countCompletedTransactions")
    public JSONObject countCompletedTransactions(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName, roleId");
        return transactionService.countCompletedTransactions(requestJson);
    }

    /**
     * 未完成交易数
     */
    @PostMapping("/countOutstandingTransactions")
    public JSONObject countOutstandingTransactions(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "unitName, roleId");
        return transactionService.countOutstandingTransactions(requestJson);
    }
}

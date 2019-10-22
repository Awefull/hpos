package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.CostManagementService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Cost")
public class CostManagementController {

    @Autowired
    private CostManagementService CostManagementService;

    /**
     * 查询支付情况到列表
     */
    @GetMapping("/getCostManagement")
    public JSONObject listCostManagement(HttpServletRequest request) {
        return CostManagementService.listCostManagement(CommonUtil.request2Json(request));
    }

    /**
     * 更新定金支付完成的账户
     */
    @PostMapping("/updateCostDeposit")
    public JSONObject updateExamineAccount(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName, studioName, deposit, depositIsPayed, finalPayment, finalPaymentIsPayed");
        return CostManagementService.updateCostDeposit(requestJson);
    }

    /**
     * 更新尾款支付完成的账户
     */
    @PostMapping("/updateCostFinal_payment")
    public JSONObject updateAdvertisementExamineAccount(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "projectName, companyName, studioName, deposit, depositIsPayed, finalPayment, finalPaymentIsPayed");
        return CostManagementService.updateCostFinal_payment(requestJson);
    }
}

package com.heeexy.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.ClassifyService;
import com.heeexy.example.service.DemandService;
import com.heeexy.example.service.CompanyProjectManagementService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wwq
 * @description: 发布需求controller
 * @date: 2019/3/28 20:48
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private DemandService demandService;

    @Autowired
    private CompanyProjectManagementService companyProjectManagementService;


    @PostMapping("/getAllDemand")
    public JSONObject getAllDemand(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson,"projectType,tenderStatus,recruitmentRole");
        return classifyService.getAllDemand(requestJson);
    }

    @PostMapping("/getDemandByProjectName")
    public JSONObject getDemandByProjectName(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson,"projectName,projectId");
        return classifyService.getDemandByProjectName(requestJson);
    }

    @PostMapping("/getDemandIdByProjectName")
    public JSONObject getDemandIdByProjectName(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson,"projectName,companyName");
        return classifyService.getDemandIdByProjectName(requestJson);
    }


    @PostMapping("/participationProject")
    public JSONObject participationProject(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson,"projectName,deposit,finalPayment,companyName,studioName");

        List<JSONObject> list =  classifyService.isAlreadyparticipated(requestJson);
        //参加项目
        JSONObject jsonObject = new JSONObject();
        if ( list.size()==0 ) {
            jsonObject = classifyService.participationProject(requestJson);
            if (classifyService.participationProject(requestJson).getString("msg").equals("请求成功")) {
                //demand表中的apply_num字段+1
                demandService.participationProjectSuccess(requestJson);
                companyProjectManagementService.participationProjectSuccess(requestJson);
            }
            return jsonObject;
        }
        jsonObject.put("code", Constants.SUCCESS_CODE);
        jsonObject.put("msg", Constants.SUCCESS_MSG);
        jsonObject.put("info", "已参与");
        return jsonObject;
    }

    @PostMapping("/filterDemand")
    public JSONObject filterDemand(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson,"projectType,tenderStatus,recruitmentRole");
        String item1 = requestJson.getString("projectType");
        String item2 = requestJson.getString("tenderStatus");
        String item3 = requestJson.getString("recruitmentRole");
        String all = "全部";
        if(all.equals(item1) && !all.equals(item2) && !all.equals(item3)) {
            return classifyService.filterStatusAndRole(requestJson);
        } else if(all.equals(item2) && !all.equals(item1) && !all.equals(item3)) {
            return classifyService.filterTypeAndRole(requestJson);
        } else if(all.equals(item3) && !all.equals(item1) && !all.equals(item2)) {
            return classifyService.filterTypeAndStatus(requestJson);
        } else if(!all.equals(item1) && all.equals(item2) && all.equals(item3)) {
            return classifyService.filterType(requestJson);
        } else if(all.equals(item1) && !all.equals(item2) && all.equals(item3)) {
            return classifyService.filterStatus(requestJson);
        } else if(all.equals(item1) && all.equals(item2) && !all.equals(item3)) {
            return classifyService.filterRole(requestJson);
        } else {
            return classifyService.getAllDemand(requestJson);
        }
    }

}

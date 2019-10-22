package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
/**
 * @author: wwq
 * @description: 发布需求controller
 * @date: 2019/3/24 17:50
 */

public interface DemandService {
    /**
     * 用户列表
     */
    JSONObject releaseDemand(JSONObject jsonObject);

    JSONObject participationProjectSuccess(JSONObject jsonObject);
}

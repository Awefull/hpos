package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.DemandDao;
import com.heeexy.example.service.ArticleService;
import com.heeexy.example.service.DemandService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: wwq
 * @description: 发布需求controller
 * @date: 2019/3/24 17:50
 */
@Service
public class DemandServiceImpl implements DemandService {
    @Autowired
    private DemandDao demandDao;

    /**
     * 文章列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject releaseDemand(JSONObject jsonObject) {
        demandDao.releaseDemand(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject participationProjectSuccess(JSONObject jsonObject) {
        demandDao.participationProjectSuccess(jsonObject);
        return CommonUtil.successJson();
    }
}

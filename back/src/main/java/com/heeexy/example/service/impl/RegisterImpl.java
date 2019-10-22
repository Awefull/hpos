package com.heeexy.example.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.ClassifyDao;
import com.heeexy.example.dao.RegisterDao;
import com.heeexy.example.service.RegisterService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisterImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject register(JSONObject jsonObject) {
        registerDao.register(jsonObject);
        return CommonUtil.successJson();
    }
}

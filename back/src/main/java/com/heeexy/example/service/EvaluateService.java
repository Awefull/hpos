package com.heeexy.example.service;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EvaluateService {

    List<JSONObject> evaluateOneStudioList(JSONObject jsonObject);

    JSONObject evaluate(JSONObject json);
}

package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface EvaluateDao {

    List<JSONObject> evaluateOneStudioList(JSONObject jsonObject);

//    JSONObject evaluate(JSONObject json);
}

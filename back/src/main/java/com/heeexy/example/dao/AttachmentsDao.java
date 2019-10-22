package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface AttachmentsDao {

    int saveAttachments(JSONObject jsonObject);

    int getFileNum();

    int addAttachmentIdToAdvertisementByFileName(JSONObject jsonObject);

    /**
     * 查询审核结果
     */
    List<JSONObject> getResultsList(JSONObject jsonObject);

}

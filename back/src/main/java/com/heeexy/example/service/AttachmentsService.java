package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

public interface AttachmentsService {

    /**
     * 附件上传
     */
    JSONObject saveAttachments(JSONObject jsonObject);

    int getFileNum();

    JSONObject addAttachmentIdToAdvertisementByFileName(JSONObject jsonObject);

    /**
     * 查询审核结果
     */
    JSONObject getResultsList(JSONObject jsonObject);
}

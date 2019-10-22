package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author: hxy
 * @date: 2017/10/24 16:06
 */
@Service
public interface ArticleService {
	/**
	 * 新增文章
	 */
	JSONObject addArticle(JSONObject jsonObject);

	/**
	 * 文章列表
	 */
	JSONObject listArticle(JSONObject jsonObject);

	/**
	 * 更新文章
	 */
	JSONObject updateArticle(JSONObject jsonObject);

	JSONObject Example(JSONObject jsonObject);
}

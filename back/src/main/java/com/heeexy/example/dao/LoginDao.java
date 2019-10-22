package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: hxy
 * @description: 登录相关dao
 * @date: 2017/10/24 11:02
 */
public interface LoginDao {
	/**
	 * 根据用户名和密码查询对应的用户
	 */
	JSONObject getUser(@Param("username") String username, @Param("password") String password);
	/**
	 * 查询企业信息
	 */
//	JSONObject getWxLoginMessage(String username,String password);

	int getAppLoginMessage(JSONObject jsonObject);
	List<JSONObject> listLogin(JSONObject jsonObject);
}

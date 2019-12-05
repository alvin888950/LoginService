package com.alvin.dao;

import org.springframework.stereotype.Service;

import com.alvin.common.DaoException;
import com.alvin.entity.Admin;

/**
 * @Title :Admin.java
 * @Company :永硕
 * @Package :com.alvin.dao
 * @Description :管理人员表接口类
 * @author :fxd
 * @date :2019-11-28 22:22
 * @version :版本 3.0
 */
public interface IadminDao {
	 	
	/**
	 * 账号登录
	 * @param loginName 用户名
	 * @param pwd 密码
	 * @param orgId 机构编号
	 * @return
	 * @throws DaoException 
	 */
	Admin accountLogin(String loginName,String pwd,Integer orgId) throws DaoException;

}
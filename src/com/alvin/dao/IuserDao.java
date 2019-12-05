package com.alvin.dao;

import com.alvin.common.DaoException;
import com.alvin.result.UserResult;

/**
 * @Title :User.java
 * @Company :永硕
 * @Package :com.alvin.dao
 * @Description :用户表接口类
 * @author :fxd
 * @date :2019-11-28 22:22
 * @version :版本 3.0
 */
public interface IuserDao {
	 
	UserResult login(String username,String pwd,Integer orgId) throws DaoException;

}
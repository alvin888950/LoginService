package com.alvin.dao.impl;

import com.alvin.common.DaoException;
import com.alvin.dao.DBSource;
import com.alvin.dao.IuserDao;
import com.alvin.result.UserResult;

/**
 * @Title :IuserDao.java
 * @Company :永硕
 * @Package :com.alvin.dao.impl
 * @Description :用户表接口实现类
 * @author :fxd
 * @date :2019-11-28 22:22
 * @version :版本 3.0
 */
public class UserImpl extends DBSource implements IuserDao {

	@Override
	public UserResult login(String username, String pwd) throws DaoException {
		String sql="select * from user where userLoginName='"+username+"' and userPwd='"+pwd+"'";
		return super.getSql().selectOne(sql, UserResult.class);
	}

 
}
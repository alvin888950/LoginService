package com.alvin.dao;

import com.alvin.common.DaoException;
import com.alvin.entity.Role;

/**
 * @Title :Role.java
 * @Company :永硕
 * @Package :com.alvin.dao
 * @Description :角色表接口类
 * @author :fxd
 * @date :2019-11-28 22:22
 * @version :版本 3.0
 */
public interface IroleDao {
	 
	Role selectOne(Integer roleId) throws DaoException;
}
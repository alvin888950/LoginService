package com.alvin.dao.impl;

import com.alvin.common.DaoException;
import com.alvin.dao.DBSource;
import com.alvin.dao.IroleDao;
import com.alvin.entity.Role;

/**
 * @Title :IroleDao.java
 * @Company :永硕
 * @Package :com.alvin.dao.impl
 * @Description :角色表接口实现类
 * @author :fxd
 * @date :2019-11-28 22:22
 * @version :版本 3.0
 */
public class RoleImpl extends DBSource implements IroleDao {

	@Override
	public Role selectOne(Integer roleId) throws DaoException {
		String sql="select * from role where roleId="+roleId;
		return super.getSql().selectOne(sql, Role.class);
	}
 
}
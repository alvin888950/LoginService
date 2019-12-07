package com.alvin.dao.impl;

import com.alvin.dao.DBSource;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alvin.dao.IadminDao;
import com.alvin.entity.Admin;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 * @Title :IadminDao.java
 * @Company :永硕
 * @Package :com.alvin.dao.impl
 * @Description :管理人员表接口实现类
 * @author :fxd
 * @date :2019-11-28 22:22
 * @version :版本 3.0
 */
public class AdminImpl extends DBSource implements IadminDao {

	@Override
	public Admin accountLogin(String loginName, String pwd, Integer orgId) throws DaoException {
		StringBuffer sql=new  StringBuffer();
		sql.append("select * from admin where orgId=").append(orgId);
		sql.append(" and adminLoginName='").append(loginName).append("'");
		sql.append(" and adminPwd ='").append(pwd).append("'");
		return super.getSql().selectOne(sql.toString(), Admin.class);
	}

	@Override
	public Admin selectAdmiById(Integer adminId) throws DaoException {
		String sql="select * from admin where adminId="+adminId;
		return super.getSql().selectOne(sql, Admin.class);
	}
}
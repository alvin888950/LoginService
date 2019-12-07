package com.alvin.service.select;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.dao.IadminDao;
import com.alvin.dao.impl.AdminImpl;
import com.alvin.entity.Admin;

import net.sf.json.JSONObject;

/**
 * 通过编号查询管理员信息
 * @author Alvin
 *
 */
public class SelectAdminByID {

	private IadminDao dao;
	private JSONObject jsonObj;

	public SelectAdminByID(JSONObject jsonObj) {
		dao=new AdminImpl();
		this.jsonObj = jsonObj;
	}

	public JSONObject getResul(Integer adminId) throws DaoException {
		Admin admin=dao.selectAdmiById(adminId);
		admin.setAdminPwd(null);
		jsonObj.put("result", admin);
		CodeResult.setResult(jsonObj, 0);
		return jsonObj;
	}
}

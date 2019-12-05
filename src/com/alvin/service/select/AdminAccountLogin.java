package com.alvin.service.select;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.dao.IadminDao;
import com.alvin.dao.impl.AdminImpl;
import com.alvin.entity.Admin;

import net.sf.json.JSONObject;

/**
 * 管理员账号登录
 * @author Alvin
 *
 */
@Service
public class AdminAccountLogin {

	private IadminDao adminDao;
	private JSONObject jsonObj;
	public AdminAccountLogin(JSONObject jsonObj){
		this.jsonObj=jsonObj;
		this.adminDao=new AdminImpl();
	}
	
	public JSONObject getResult(String loginName,String pwd,Integer orgId) throws DaoException{
		Admin admin=adminDao.accountLogin(loginName, pwd, orgId);
		if (admin==null) {
			CodeResult.setResult(jsonObj, 14);
			return jsonObj;
		}
		ValidateRoleAuthority servie=new ValidateRoleAuthority(jsonObj);
		String roleName=servie.getResult(admin.getRoleId());
		admin.setRoleName(roleName);
		if (jsonObj.get("code").equals(0)) { 
			jsonObj.put("result", admin);
		}
		
		return jsonObj;
	}
	
}

package com.alvin.service.select;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.dao.IuserDao;
import com.alvin.dao.impl.UserImpl;
import com.alvin.result.UserResult;

import net.sf.json.JSONObject;

/**
 * 账号登录
 * @author Alvin
 *
 */
public class UserAccountLogin {
	
	private JSONObject jsonObj;
	private IuserDao dao;
	public UserAccountLogin(JSONObject jsonObj){
		this.jsonObj=jsonObj;
		dao=new UserImpl();
	}
	
	public JSONObject getResult(String username,String pwd,Integer orgId) throws DaoException{
		CodeResult.setResult(jsonObj, 0);
		UserResult user= dao.login(username, pwd,orgId);
		if (user==null) {
			CodeResult.setResult(jsonObj, 12);
			return jsonObj;
		}
		if (user.getUserState()==null||user.getUserState().equals(0)) {
			CodeResult.setResult(jsonObj, 13);
			return jsonObj;
		}
		ValidateRoleAuthority servie=new ValidateRoleAuthority(jsonObj);
		String roleName=servie.getResult(user.getRoleId());
		user.setRoleName(roleName);
		if (jsonObj.get("code").equals("00")) {
			jsonObj.put("result", user);
		}
		return jsonObj;
	}

}

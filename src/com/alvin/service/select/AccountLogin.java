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
public class AccountLogin {
	
	private JSONObject jsonObj;
	private IuserDao dao;
	public AccountLogin(JSONObject jsonObj){
		this.jsonObj=jsonObj;
		dao=new UserImpl();
	}
	
	public JSONObject getResult(String username,String pwd) throws DaoException{
		CodeResult.setResult(jsonObj, 0);
		UserResult user= dao.login(username, pwd);
		ValidateUserAuthority servie=new ValidateUserAuthority(jsonObj);
		servie.getResult(user);
		return jsonObj;
	}

}

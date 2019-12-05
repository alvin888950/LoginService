package com.alvin.service.select;

import com.alvin.common.CodeResult;
import com.alvin.common.DaoException;
import com.alvin.dao.IroleDao;
import com.alvin.dao.impl.RoleImpl;
import com.alvin.entity.Role;
import com.alvin.result.UserResult;

import net.sf.json.JSONObject;

/**
 * 验证用户权限
 * @author Alvin
 *
 */
public class ValidateUserAuthority {

	private Role role;
	private JSONObject jsonObj;
	public ValidateUserAuthority(JSONObject jsonObj){
		this.jsonObj=jsonObj;
	}
	
	public JSONObject getResult(UserResult user) throws DaoException{
		if (user==null) {
			CodeResult.setResult(jsonObj, 12);
			return jsonObj;
		}
		if (user.getUserState()==null||user.getUserState().equals(0)) {
			CodeResult.setResult(jsonObj, 13);
			return jsonObj;
		}
		if (getRole(user.getRoleId())==false) {
			return jsonObj;
		}
		user.setRoleName(role.getRoleName());
		jsonObj.put("data", user);
		return jsonObj;
	}
	
	private Boolean getRole(Integer roleId) throws DaoException{
		IroleDao dao=new RoleImpl();
		role= dao.selectOne(roleId);
		if (role.getUseState().equals(0)) {
			CodeResult.setResult(jsonObj, 13);
			return false;
		}
		return true;
	}
}

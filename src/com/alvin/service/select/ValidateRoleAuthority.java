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
public class ValidateRoleAuthority {

	private Role role;
	private JSONObject jsonObj;
	public ValidateRoleAuthority(JSONObject jsonObj){
		this.jsonObj=jsonObj;
	}
	
	public String getResult(Integer roleId) throws DaoException{
		
		if (getRole(roleId)==false) {
			return "";
		}
		return role.getRoleName();
	}
	
	private Boolean getRole(Integer roleId) throws DaoException{
		IroleDao dao=new RoleImpl();
		role= dao.selectOne(roleId);
		if (role==null||role.getUseState().equals(0)) {
			CodeResult.setResult(jsonObj, 13);
			return false;
		}
		return true;
	}
}

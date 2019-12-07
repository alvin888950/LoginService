package com.alvin.service.select;

import com.alvin.common.CodeResult;
import com.alvin.common.Config_Xml;
import com.alvin.common.DaoException;
import com.alvin.common.RSAUtil;
import com.alvin.common.StringUtil;
import com.alvin.entity.Admin;

import net.sf.json.JSONObject;

/**
 * 获取管理员信息
 * @author Alvin
 *
 */
public class GetAdminSimpleInfo {
	
	
	private Admin adminInfo;
	private JSONObject jsonObj;
	public GetAdminSimpleInfo(JSONObject jsonObj){
		this.jsonObj=jsonObj;
	}
	
	public JSONObject getResul(String token,Integer type) throws DaoException{
		decryptAdmin(token);
		CodeResult.setResult(jsonObj, 0);
		switch (type) {
		case 1:
			jsonObj.put("result", adminInfo);
			return jsonObj;
		case 2:
			new SelectAdminByID(jsonObj).getResul(adminInfo.getAdminId());
			return jsonObj;
		
		default:
			break;
		}
		
		return jsonObj;
	}
	
	/**
	 * token 解析
	 * @param token
	 * @return
	 */
	private Boolean decryptAdmin(String token){
		try {
			String decrypt = RSAUtil.decrypt(token, Config_Xml.PRIVATE_KEY);
			if (StringUtil.isBlank(decrypt)) {
				CodeResult.setResult(jsonObj, 100);
				return false;
			}
			 String[] result=decrypt.split("_");
			 adminInfo=new Admin();
			 adminInfo.setAdminId(Integer.parseInt(result[0]));
			 adminInfo.setAdminLoginName(result[1]);
			 adminInfo.setOrgId(Integer.parseInt(result[2]));
			 return true;
		} catch (Exception e) {
			throw e;
		}
		
	}
}

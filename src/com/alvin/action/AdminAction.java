package com.alvin.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alvin.common.CodeResult;
import com.alvin.common.StringUtil;
import com.alvin.service.select.AdminAccountLogin;
import com.alvin.service.select.UserAccountLogin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

/**
 * @Title :UserAction.java
 * @Company :永硕
 * @Package :com.alvin.action
 * @Description :用户表控制器类
 * @author :fxd
 * @date :2019-11-28 21:13
 * @version :版本 3.0
 */
@Controller
@RequestMapping(value = { "admin" })
@Api(value = "user", description = "管理员API")
public class AdminAction extends BaseAction {

	 /**
	  * 账号登录
	  * @param request
	  * @param response
	  * @param username
	  * @param pwd
	  */
	@ApiOperation(httpMethod = "GET", value = "账号登录")
	@RequestMapping("accountLogin")
	 public void accountLogin(HttpServletRequest request,HttpServletResponse response,@RequestParam String username,@RequestParam String pwd,@RequestParam Integer orgId){
		 JSONObject jsonObj = new JSONObject();
		try {
			if (StringUtil.isBlank(username)||StringUtil.isBlank(pwd)) {
				CodeResult.setResult(jsonObj, 11,"用户名或密码");
				return;
			}
			AdminAccountLogin service=new AdminAccountLogin(jsonObj);
			service.getResult(username, pwd,orgId);
		} catch (Exception e) {
			CodeResult.setResult(jsonObj, 99);
			e.printStackTrace();
		} finally {
			super.out(response, jsonObj);
		}
	 }
}
package com.alvin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alvin.action.BaseAction;
import com.alvin.common.CodeResult;
import com.alvin.common.Config_Xml;
import com.alvin.common.RSAUtil;
import com.alvin.common.StringUtil;

import net.sf.json.JSONObject;

/**
 * 跨域拦截器
 * 
 * @author Alvin
 *
 */
public class CrossComainInterceptor extends BaseAction implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String Referer = request.getHeader("Referer");
		if (Referer == null || Referer.indexOf("swagger-ui") > 0 ) {
			return true;
		}
		//管理员账号登录
		if (request.getRequestURI().indexOf("admin/accountLogin")>-1) {
			crossComain(response, request);
			return true;
		}
		String token=request.getHeader("token");
		if (StringUtil.isBlank(token)) {
			jsonObj=new JSONObject();
			CodeResult.setResult(jsonObj, 100);
			return false;
		}
		  //使用私匙解密
        String decrypt = RSAUtil.decrypt(token, Config_Xml.PRIVATE_KEY);
		if (decrypt==null) {
			jsonObj=new JSONObject();
			CodeResult.setResult(jsonObj, 100);
			return false;
		}
		return true;
	}

}

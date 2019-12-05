package com.alvin.common;

import net.sf.json.JSONObject;

/**
 * @Title : CodeResult.java
 * @Company : 永硕
 * @Package : com.alvin.common
 * @Description : TODO(code 返回结果和解释)
 * @author : fxd
 * @date : 2019-4-19 下午4:35:12
 * @version : 版本 3.0
 */
public class CodeResult {

	public static void setResult(JSONObject jsonObj, Integer code, String... msg) {
		String m = null;
		if (msg.length > 0) {
			m = msg[0];
		} else {
			m = "";
		}
		setValue(jsonObj, code, m);
	}

	public static void setResult(JSONObject jsonObj, Integer code) {
		setValue(jsonObj, code, "");
	}

	private static void setValue(JSONObject jsonObj, Integer code, String msg) {
		jsonObj.put("code", code);
		switch (code) {
		case 0:
			jsonObj.put("msg", msg + "成功");
			return;
		case 99:
			jsonObj.put("msg", "服务器错误");
			return;
		case 100:
			jsonObj.put("msg", "无效token");
			return;
		case 11:
			jsonObj.put("msg", msg + "不允许为空");
			return;
		case 12:
			jsonObj.put("msg", "用户名或密码错误！");
			return;
		case 13:
			jsonObj.put("msg", "用户正在审核中！");
			return;
		case 14:
			jsonObj.put("msg", "账号或密码错误！");
			return;
		default:
			break;
		}
	}

}

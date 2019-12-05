package com.alvin.result;

import lombok.Data;

/**
 * 用户返回结果
 * @author Alvin
 *
 */
@Data
public class UserResult {

	private Integer userId;//用户编号
	private String userLoginName;
	private String userName;
	private Integer roleId;
	private String roleName;
	private Integer userState;
}

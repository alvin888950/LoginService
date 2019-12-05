package com.alvin.entity;

/**
 * @Title :Admin.java
 * @Company :永硕
 * @Package :com.alvin.entity
 * @Description :管理人员表实体类
 * @author :fxd
 * @date :2019-11-26 22:51
 * @version :版本 3.0
 */
public class Admin {
	private Integer ADMIN_ID;// ID
	private String adminName;// 姓名
	private String adminLoginName;// 用户名
	private String adminPwd;// 密码
	private Integer ROLE_ID;// 角色
	private String adminPhone;// 联系电话
	private Integer userState;// 状态 1.正常 0.禁用
	private Integer ORG_ID;// 机构编号
	private String createTime;// 创建时间
	private String updateTime;// 修改时间

	public Integer getADMIN_ID() {
		return ADMIN_ID;
	}

	public void setADMIN_ID(Integer ADMIN_ID) {
		this.ADMIN_ID = ADMIN_ID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminLoginName() {
		return adminLoginName;
	}

	public void setAdminLoginName(String adminLoginName) {
		this.adminLoginName = adminLoginName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public Integer getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(Integer ROLE_ID) {
		this.ROLE_ID = ROLE_ID;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public Integer getORG_ID() {
		return ORG_ID;
	}

	public void setORG_ID(Integer ORG_ID) {
		this.ORG_ID = ORG_ID;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
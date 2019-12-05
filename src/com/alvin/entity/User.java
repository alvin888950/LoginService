package com.alvin.entity;

/**
 * @Title :User.java
 * @Company :永硕
 * @Package :com.alvin.entity
 * @Description :用户表实体类
 * @author :fxd
 * @date :2019-11-26 22:51
 * @version :版本 3.0
 */
public class User {
	private Integer USER_ID;// ID
	private String userNo;// 编号
	private String userJobNo;// 工号
	private String userName;// 姓名
	private String userType;// 类型 1.内部
	private String DEPARTMENT_ID;// 部门
	private Integer DIVISION_ID;// 科室
	private String userLoginName;// 用户名
	private String userPwd;// 密码
	private Integer ROLE_ID;// 角色
	private String userIDcard;// 身份证号
	private Integer gender;// 性别
	private String address;// 地址
	private Integer occupation;// 岗位
	private String userPhone;// 联系电话
	private String userPhoto;// 照片
	private Integer userState;// 状态 1.正常 0.禁用
	private Integer ORG_ID;// 机构编号
	private String createTime;// 创建时间
	private String updateTime;// 修改时间

	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer USER_ID) {
		this.USER_ID = USER_ID;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserJobNo() {
		return userJobNo;
	}

	public void setUserJobNo(String userJobNo) {
		this.userJobNo = userJobNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}

	public void setDEPARTMENT_ID(String DEPARTMENT_ID) {
		this.DEPARTMENT_ID = DEPARTMENT_ID;
	}

	public Integer getDIVISION_ID() {
		return DIVISION_ID;
	}

	public void setDIVISION_ID(Integer DIVISION_ID) {
		this.DIVISION_ID = DIVISION_ID;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(Integer ROLE_ID) {
		this.ROLE_ID = ROLE_ID;
	}

	public String getUserIDcard() {
		return userIDcard;
	}

	public void setUserIDcard(String userIDcard) {
		this.userIDcard = userIDcard;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getOccupation() {
		return occupation;
	}

	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
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
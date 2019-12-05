package com.alvin.entity;

/**
 * @Title :Role.java
 * @Company :永硕
 * @Package :com.alvin.entity
 * @Description :角色表实体类
 * @author :fxd
 * @date :2019-11-26 22:51
 * @version :版本 3.0
 */
public class Role {
	private Integer ROLE_ID;// ID
	private String roleName;// 角色名
	private Integer useState;// 启用状态 0.未启用 1.已启用
	private String remark;// 备注
	private Integer roleType;// 角色类型 1：管理员 2：普通用户
	private Integer ORG_ID;// 机构编号
	private String createTime;// 创建时间
	private String updateTime;// 修改时间

	public Integer getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(Integer ROLE_ID) {
		this.ROLE_ID = ROLE_ID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getUseState() {
		return useState;
	}

	public void setUseState(Integer useState) {
		this.useState = useState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
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
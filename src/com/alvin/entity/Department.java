package com.alvin.entity;

/**
 * @Title :Department.java
 * @Company :永硕
 * @Package :com.alvin.entity
 * @Description :部门表实体类
 * @author :fxd
 * @date :2019-11-26 22:51
 * @version :版本 3.0
 */
public class Department {
	private Integer DEPARTMENT_ID;// ID
	private String dmName;// 名称
	private Integer pid;// 父级编号
	private String pids;// 父级连编号
	private Integer ORG_ID;// 机构编号
	private String createTime;// 创建时间
	private String updateTime;// 修改时间

	public Integer getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}

	public void setDEPARTMENT_ID(Integer DEPARTMENT_ID) {
		this.DEPARTMENT_ID = DEPARTMENT_ID;
	}

	public String getDmName() {
		return dmName;
	}

	public void setDmName(String dmName) {
		this.dmName = dmName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPids() {
		return pids;
	}

	public void setPids(String pids) {
		this.pids = pids;
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
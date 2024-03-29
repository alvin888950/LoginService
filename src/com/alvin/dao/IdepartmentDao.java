package com.alvin.dao;

import com.alvin.entity.Department;

import java.util.List;
import java.util.Map;
import com.alvin.common.DaoException;

/**
 * @Title :Department.java
 * @Company :永硕
 * @Package :com.alvin.dao
 * @Description :部门表接口类
 * @author :fxd
 * @date :2019-11-28 22:22
 * @version :版本 3.0
 */
public interface IdepartmentDao {
	/**
	 * 添加
	 * 
	 * @author alvin
	 * @return
	 * @since
	 */
	void addDepartment(Department department) throws DaoException;

	/**
	 * 删除
	 * 
	 * @author alvin
	 * @return
	 * @since
	 */
	void delDepartmentById(String DEPARTMENT_IDs) throws DaoException;

	/**
	 * 修改
	 * 
	 * @author alvin
	 * @return
	 * @since
	 */
	void updDepartment(Department department) throws DaoException;

	/**
	 * 查询
	 * 
	 * @author alvin
	 * @return
	 * @since
	 */
	List<Department> selectByMapDepartment(Department department, Map<String, Object> map) throws DaoException;

	/**
	 * 统计总数
	 * 
	 * @author alvin
	 * @return
	 * @since
	 */
	Integer countByMapDepartment(Department department, Map<String, Object> map) throws DaoException;

	/**
	 * 通过编号查询
	 * 
	 * @author alvin
	 * @return
	 * @since
	 */
	Department selectOneByID(Integer ID) throws DaoException;

	/**
	 * 通过编号查询
	 * 
	 * @author alvin
	 * @return
	 * @since
	 */
	Department selectOneByObj(Department entity) throws DaoException;

}
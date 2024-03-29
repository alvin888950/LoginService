package com.alvin.dao.impl;

import com.alvin.dao.DBSource;
import java.util.List;
import java.util.Map;
import com.alvin.dao.IdepartmentDao;
import com.alvin.entity.Department;
import com.alvin.common.ObjectConvertStr;
import com.alvin.common.DaoException;

/**
 * @Title :IdepartmentDao.java
 * @Company :永硕
 * @Package :com.alvin.dao.impl
 * @Description :部门表接口实现类
 * @author :fxd
 * @date :2019-11-28 22:22
 * @version :版本 3.0
 */
public class DepartmentImpl extends DBSource implements IdepartmentDao {

	/**
	 * 添加
	 * 
	 * @author :fxd
	 * @return :
	 * @date :2019-11-28 22:22
	 */
	@Override
	public void addDepartment(Department department) throws DaoException {
		String sql = "insert into department(DEPARTMENT_ID,dmName,pid,pids,ORG_ID,createTime,updateTime) values(?,?,?,?,?,?,?)";
		Object[] pramas = { department.getDEPARTMENT_ID(), department.getDmName(), department.getPid(),
				department.getPids(), department.getORG_ID(), department.getCreateTime(), department.getUpdateTime() };
		super.getSql().executeUpdate(sql, pramas);
	};

	/**
	 * 通过编号删除
	 * 
	 * @author :fxd
	 * @return :
	 * @date :2019-11-28 22:22
	 */
	@Override
	public void delDepartmentById(String DEPARTMENT_IDs) throws DaoException {
		String sql = "delete from  department where DEPARTMENT_ID in(" + DEPARTMENT_IDs + ")";
		super.getSql().executeUpdate(sql);
	}

	/**
	 * 修改
	 * 
	 * @author :fxd
	 * @return :
	 * @date :2019-11-28 22:22
	 */
	@Override
	public void updDepartment(Department department) throws DaoException {
		StringBuffer sql = new StringBuffer();
		sql.append("update department set DEPARTMENT_ID=DEPARTMENT_ID");
		ObjectConvertStr.cUpdSql(department, sql);
		sql.append(" where DEPARTMENT_ID=" + department.getDEPARTMENT_ID());

		super.getSql().executeUpdate(sql.toString());
	}

	/**
	 * 通过条件查询
	 * 
	 * @author :fxd
	 * @return :
	 * @date :2019-11-28 22:22
	 */
	@Override
	public List<Department> selectByMapDepartment(Department department, Map<String, Object> map) throws DaoException {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from department where 1=1");
		commonSqlByMap(department, map, sql);
		return super.getSql().selectList(sql.toString(), Department.class);

	}

	/**
	 * 公共的条件转换sql
	 * 
	 * @author :fxd
	 * @return :
	 * @date :2019-11-28 22:22
	 */
	private String commonSqlByMap(Department Department, Map<String, Object> map, StringBuffer sql) {

		ObjectConvertStr.cSelectSql(Department, sql, true);
		if (map == null) {
			return sql.toString();
		}
		;
		if (map.get("pageIndex") != null && !map.get("pageIndex").equals("")) {
			Integer pageindex = Integer.parseInt(map.get("pageIndex").toString());
			Integer pagesize = Integer.parseInt(map.get("pageSize").toString());
			sql.append(" limit " + ((pageindex - 1) * pagesize) + "," + pagesize);
		}
		return sql.toString();
	}

	/**
	 * 通过条件查询数量
	 * 
	 * @author :fxd
	 * @return :
	 * @date :2019-11-28 22:22
	 */
	@Override
	public Integer countByMapDepartment(Department department, Map<String, Object> map) throws DaoException {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(1) as count from department where 1=1");
		commonSqlByMap(department, map, sql);
		return super.getSql().selectCount(sql.toString());

	}

	/**
	 * 通过编号查询
	 * 
	 * @author :fxd
	 * @return :
	 * @date :2019-11-28 22:22
	 */
	public Department selectOneByID(Integer ID) throws DaoException {

		String sql = "select * from department where  DEPARTMENT_ID=" + ID;
		return super.getSql().selectOne(sql, Department.class);
	}

	/**
	 * 通过编号查询
	 * 
	 * @author :fxd
	 * @return :
	 * @date :2019-11-28 22:22
	 */
	public Department selectOneByObj(Department entity) throws DaoException {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from department where 1=1 ");
		commonSqlByMap(entity, null, sql);

		return super.getSql().selectOne(sql.toString(), Department.class);
	}
}
package com.fanx.template.dao.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fanx.template.base.dao.impl.BaseDaoImpl;
import com.fanx.template.dao.basedata.DepartmentDao;
import com.fanx.template.domain.basedata.Department;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;
/**
 * 部门组织结构dao
 * @author fanx
 *
 */
@Repository("DepartmentDaoImpl")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		DepartmentDao {

}

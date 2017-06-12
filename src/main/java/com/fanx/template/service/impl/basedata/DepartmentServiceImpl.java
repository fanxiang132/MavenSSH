package com.fanx.template.service.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fanx.template.base.dao.BaseDao;
import com.fanx.template.base.service.impl.BaseServiceImpl;
import com.fanx.template.dao.basedata.DepartmentDao;
import com.fanx.template.domain.basedata.Department;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;
import com.fanx.template.service.basedata.DepartmentService;
/**
 * 部门组织业务
 * @author fanx
 *
 */
@Service("DepartmentServiceImpl")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements
		DepartmentService {

//	@Resource(name="DepartmentDaoImpl")
//	private DepartmentDao departmentDao;
	
	@Override
	public BaseDao getBaseDao() {
		return null;
	}
 
}

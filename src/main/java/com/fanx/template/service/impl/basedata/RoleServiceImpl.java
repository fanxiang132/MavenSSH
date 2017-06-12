package com.fanx.template.service.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fanx.template.base.dao.BaseDao;
import com.fanx.template.base.service.impl.BaseServiceImpl;
import com.fanx.template.dao.basedata.RoleDao;
import com.fanx.template.domain.basedata.Role;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;
import com.fanx.template.service.basedata.RoleService;
/*
 * 
 * 角色业务类
 */
@Service("RoleServiceImpl")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {

	@Resource(name="RoleDaoImpl")
	private RoleDao roleDao;
	
	@Override
	public BaseDao getBaseDao() {
		return roleDao;
	}

	 
}

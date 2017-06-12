package com.fanx.template.service.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fanx.template.base.dao.BaseDao;
import com.fanx.template.base.service.impl.BaseServiceImpl;
import com.fanx.template.dao.basedata.PrivilegeDao;
import com.fanx.template.domain.basedata.Privilege;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;
import com.fanx.template.service.basedata.PrivilegeService;
/**
 * 权限控制
 * @author fanx
 *
 */
@Service("PrivilegeServiceImpl")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements
		PrivilegeService {

	@Resource(name="PrivilegeDaoImpl")
	private PrivilegeDao privilegeDao;
	
	@Override
	public BaseDao getBaseDao() {
		return privilegeDao;
	}
 
}

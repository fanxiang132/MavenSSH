package com.fanx.template.dao.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fanx.template.base.dao.impl.BaseDaoImpl;
import com.fanx.template.dao.basedata.PrivilegeDao;
import com.fanx.template.domain.basedata.Privilege;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;
/**
 * 权限dao
 * @author fanx
 *
 */
@Repository("PrivilegeDaoImpl")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements
		PrivilegeDao {
 
}

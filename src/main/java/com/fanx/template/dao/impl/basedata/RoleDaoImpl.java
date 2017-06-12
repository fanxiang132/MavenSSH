package com.fanx.template.dao.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fanx.template.base.dao.impl.BaseDaoImpl;
import com.fanx.template.dao.basedata.RoleDao;
import com.fanx.template.domain.basedata.Role;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;

/**
 * 角色持久类
 * @author fanx
 *
 */
@Repository("RoleDaoImpl")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {


}

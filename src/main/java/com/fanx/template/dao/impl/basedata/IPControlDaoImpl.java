package com.fanx.template.dao.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fanx.template.base.dao.impl.BaseDaoImpl;
import com.fanx.template.dao.basedata.IPControlDao;
import com.fanx.template.domain.basedata.IPControl;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;

/**
 * ip限制dao
 * @author fanx
 *
 */
@Repository("IPControlDaoImpl")
public class IPControlDaoImpl extends BaseDaoImpl<IPControl> implements
		IPControlDao {
 

}

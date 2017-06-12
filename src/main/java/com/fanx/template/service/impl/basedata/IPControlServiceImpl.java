package com.fanx.template.service.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fanx.template.base.dao.BaseDao;
import com.fanx.template.base.service.impl.BaseServiceImpl;
import com.fanx.template.dao.basedata.IPControlDao;
import com.fanx.template.domain.basedata.IPControl;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;
import com.fanx.template.service.basedata.IPControlService;
/**
 * ipservice
 * @author fanx
 *
 */
@Service("IPControlServiceImpl")
public class IPControlServiceImpl extends BaseServiceImpl<IPControl> implements
		IPControlService {

	@Resource(name="IPControlDaoImpl")
	private IPControlDao ipControlDao;	
	
	@Override
	public BaseDao getBaseDao() {
		return ipControlDao;
	}

 
}

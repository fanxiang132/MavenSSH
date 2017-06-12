package com.fanx.template.service.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fanx.template.base.dao.BaseDao;
import com.fanx.template.base.service.impl.BaseServiceImpl;
import com.fanx.template.dao.basedata.PositionDao;
import com.fanx.template.domain.basedata.Position;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;
import com.fanx.template.service.basedata.PositionService;
/**
 * 职位service
 * @author fanx
 *
 */
@Service("PositionSerivceImpl")
public class PositionSerivceImpl extends BaseServiceImpl<Position> implements
		PositionService {

	@Resource(name="PositionDaoImpl")
	private PositionDao pDao;
	
	@Override
	public BaseDao getBaseDao() {
		return pDao;
	}

}

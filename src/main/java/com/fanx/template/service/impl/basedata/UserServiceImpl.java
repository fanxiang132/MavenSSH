package com.fanx.template.service.impl.basedata;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fanx.template.base.dao.BaseDao;
import com.fanx.template.base.dao.impl.BaseDaoImpl;
import com.fanx.template.base.service.impl.BaseServiceImpl;
import com.fanx.template.dao.basedata.UserDao;
import com.fanx.template.domain.basedata.User;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;
import com.fanx.template.service.basedata.UserService;
/**
 * 用户业务类
 * @author fanx
 *
 */
@Service("UserServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource(name="UserDaoImpl")
	private UserDao userDao;
	
	@Override
	public BaseDao getBaseDao() {
		return userDao;
	}

	 

}

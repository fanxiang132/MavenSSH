package com.fanx.template.dao.impl.basedata;

import org.springframework.stereotype.Repository;

import com.fanx.template.base.dao.impl.BaseDaoImpl;
import com.fanx.template.dao.basedata.UserDao;
import com.fanx.template.domain.basedata.User;
/**
 * 用户dao
 * @author fanx
 *
 */
@Repository("UserDaoImpl")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}

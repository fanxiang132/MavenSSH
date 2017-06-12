package com.fanx.template.base.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.fanx.template.base.dao.BaseDao;
import com.fanx.template.base.service.BaseService;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;


/**
 * service层基类
 * @author fanx
 *
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	public abstract BaseDao getBaseDao();
	
	@Override
	public PageResult<T> findPageResult(BaseQuery baseQuery) {
		return this.getBaseDao().findPageResult(baseQuery);
	}

	@Override
	public Collection<T> findEntry() {
		return  this.getBaseDao().findEntry();
	}

	@Transactional
	public void saveEntry(T t) {
		 this.getBaseDao().saveEntry(t);
		
	}

	@Transactional
	public void updateEntry(T t) {
		 this.getBaseDao().updateEntry(t);
		
	}

	@Transactional
	public void deleteEntriesByIDS(Serializable[] ids) {
		 this.getBaseDao().deleteEntriesByIDS(ids);
	}

	@Transactional
	public void deleteEntry(Serializable id) {
		 this.getBaseDao().deleteEntry(id);
		
	}

	@Transactional
	public T getEntryById(Serializable id) {
		return  (T) this.getBaseDao().getEntryById(id);
	}

	@Transactional
	public Set<T> getEntriesByIds(Serializable[] ids) {
		return  this.getBaseDao().getEntriesByIds(ids);
	}

	@Override
	public int getCount(BaseQuery baseQuery) {
		return  this.getBaseDao().getCount(baseQuery);
	}

}

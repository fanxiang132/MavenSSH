package com.fanx.template.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.fanx.template.base.dao.BaseDao;
import com.fanx.template.query.BaseQuery;
import com.fanx.template.query.PageResult;


/**
 * 基础dao类
 * 
 * @author fanx
 * 
 * @param <T>
 */

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class clazz;// 装载子类的泛型具体对象
	private ClassMetadata classMetadata;// hibernate实体类对象

	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	/**
	 * 初始化hibernate对象
	 */
	@PostConstruct
	public void init() {
		classMetadata = this.hibernateTemplate.getSessionFactory()
				.getClassMetadata(this.clazz);

	}

	/**
	 * 构造对象获取子类对象
	 */
	public BaseDaoImpl() {
		ParameterizedType types = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class) types.getActualTypeArguments()[0];
	}

	/**
	 * 分页获取查询数据
	 */
	@Override
	public PageResult<T> findPageResult(final BaseQuery baseQuery) {
		// 总条数
		int countsize = this.getCount(baseQuery);
		final PageResult<T> pResult = new PageResult<T>(
				baseQuery.getCurrentPage(), baseQuery.getPageSize(), countsize);
		// 拼接查询条件
		final StringBuffer sbBuffer = new StringBuffer();
		 sbBuffer.append("from "+clazz.getSimpleName()+" where 1=1 ");
		//sbBuffer.append("from Department where 1=1 ");
		// 获取键值数据
		final Map<String, Object> keyValues = baseQuery.buildWhere();
		// 遍历组装数据
		for (Map.Entry<String, Object> kvs : keyValues.entrySet()) {
			sbBuffer.append(" and " + kvs.getKey() + "=:" + kvs.getKey());
		}
		// 原生查询语句
		this.hibernateTemplate.execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(sbBuffer.toString());
				// 遍历组装数据
				for (Map.Entry<String, Object> kvs : keyValues.entrySet()) {
					query.setParameter(kvs.getKey(), kvs.getValue());
				}
				// 分页
				query.setFirstResult(
						(pResult.getCurrentPage() - 1) * pResult.getPageSize())
						.setMaxResults(pResult.getPageSize());
				List<T> us = query.list();
				pResult.setRows(us);
				return null;
			}
		});
		return pResult;
	}

	/**
	 * 查询所有数据
	 */
	@Override
	public Collection<T> findEntry() {
		return this.hibernateTemplate
				.find("from " + this.clazz.getSimpleName());
	}

	/**
	 * 保存数据
	 */
	@Override
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	/**
	 * 修改数据
	 */
	@Override
	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	/**
	 * 删除数据
	 */
	@Override
	public void deleteEntriesByIDS(final Serializable[] ids) {
		// 判断是否有值
		if (ids.length > 0) {
			this.hibernateTemplate.execute(new HibernateCallback<T>() {
				@Override
				public T doInHibernate(Session session)
						throws HibernateException, SQLException {
					StringBuffer sBuffer = new StringBuffer();
					sBuffer.append("delete from " + clazz.getSimpleName()
							+ " where 1=1");
					for (Serializable serializable : ids) {
						sBuffer.append(" and "
								+ classMetadata.getIdentifierPropertyName()
								+ " = " + serializable);
					}
					session.createSQLQuery(sBuffer.toString()).executeUpdate();
					return null;
				}

			});
		}
	}

	/**
	 * 删除单个数据
	 */
	@Override
	public void deleteEntry(Serializable id) {
		T t = (T) this.hibernateTemplate.get(clazz, id);
		this.hibernateTemplate.delete(t);
	}

	/**
	 * 获取单个数据
	 */
	@Override
	public T getEntryById(Serializable id) {
		return (T) this.hibernateTemplate.get(clazz, id);
	}

	/**
	 * 获取数据集合
	 */
	@Override
	public Set<T> getEntriesByIds(final Serializable[] ids) {
		/**
		 * [1,2,3,4]-->"1,2,3,4"
		 */
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			if(i==ids.length-1){
				stringBuffer.append(ids[i]);
			}else{
				stringBuffer.append(ids[i]+",");
			}
		}
		StringBuffer hql = new StringBuffer();
		/**
		 * this.classt.getSimpleName()是持久化类的名称
		 */
		hql.append("from "+this.clazz.getSimpleName());
		/**
		 * this.classMetadata.getIdentifierPropertyName()持久化类id的名称
		 */
		hql.append(" where "+this.classMetadata.getIdentifierPropertyName());
		hql.append(" in(");
		hql.append(stringBuffer.toString());
		hql.append(")");
		List<T> list = this.hibernateTemplate.find(hql.toString());
		return new HashSet<T>(list);//从list到set的转化
	}

	/**
	 * 查询总条数
	 */
	@Override
	public int getCount(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer stringBuffer = new StringBuffer();

				// stringBuffer.append("select count(*) from "+clazz.getSimpleName());
				// 通过主键字段查询总数量提高查询的效率
				stringBuffer.append("select count("
						+ classMetadata.getIdentifierPropertyName() + ") from "
						+ clazz.getSimpleName());
				stringBuffer.append(" where 1=1 ");

				// 获取所有的查询条件
				Map<String, Object> keyValues = baseQuery.buildWhere();
				/**
				 * 拼接where条件的过程
				 */
				for (Map.Entry<String, Object> entry : keyValues.entrySet()) {
					stringBuffer.append(" and " + entry.getKey() + "=:"
							+ entry.getKey());
				}
				Query query = session.createSQLQuery(stringBuffer.toString());// 存放一个hql语句

				/**
				 * 把where条件中的参数传递值的过程
				 */
				for (Map.Entry<String, Object> entry : keyValues.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
				}
				BigInteger um = (BigInteger) query.uniqueResult();
				return um.intValue();
			}

		});
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	
}

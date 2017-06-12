package com.fanx.template.base.action;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.classic.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * action基类
 * @author fanx
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private Class clazz;
	private T t;
	
	private int currentPage;//分页标记
	
	//采用input button方式的删除数据获取
	private String deleteids;
	
	/**
	 * 构造方法获取子类信息
	 */
	public BaseAction(){
		//获取子类的信息
		ParameterizedType pType=(ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) pType.getActualTypeArguments()[0];
		try {
			t=(T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public T getModel() {
		return t;
	}
	
	public static final String ADDUI = "addUI";//跳转到添加页面的字符串
	
	public String addUI = ADDUI;
	
	public static final String UPDATEUI = "updateUI";//跳转到修改页面的字符串
	
	public String updateUI = UPDATEUI;
	
	public static final String LISTACTION = "listAction";//跳转到列表页面的字符串
	
	public String listAction = LISTACTION;
	
	public static final String ACTION2ACTION = "action2action";//action跳转到action
	
	public String action2action = ACTION2ACTION;
	
	
	/**
	 * 获取session
	 * @return
	 */
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}

	public String getDeleteids() {
		return deleteids;
	}

	public void setDeleteids(String deleteids) {
		this.deleteids = deleteids;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
	
}

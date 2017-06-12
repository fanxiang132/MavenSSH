package com.fanx.template.domain.basedata;

import java.io.Serializable;

/**
 * 基础的包装类
 * @author fanx
 *
 */
public class BaseDomain implements Serializable{

	private int code;//记录状态类型
	private Object ob;//传递的内容
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getOb() {
		return ob;
	}
	public void setOb(Object ob) {
		this.ob = ob;
	}
	
	
}

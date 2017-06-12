package com.fanx.template.domain.basedata;

import java.io.Serializable;
/**
 * 职位表
 * @author fanx
 *
 */
public class Position implements Serializable {

	private Long pid;//职位id
	private String pname;//职位名称
	private String remark;//职位备注
	
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}

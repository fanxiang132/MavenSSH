package com.fanx.template.domain.basedata;

import java.io.Serializable;
/**
 * 部门表
 * @author fanx
 *
 */
public class Department implements Serializable {

	private Long  did; //主键
	private String  dname; //部门名称
	private Long  pid; //父
	private boolean  isparent; //是否是父类
	private String  description; //描述
	private String  icon; //图标
	private boolean isdelete=false; //是否删除
	
	public Department() {
		super();
	}
	
	public Department( String dname, Long pid, boolean isparent,
			String description, String icon) {
		super();
		this.dname = dname;
		this.pid = pid;
		this.isparent = isparent;
		this.description = description;
		this.icon = icon;
	}
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isIsdelete() {
		return isdelete;
	}
	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}
	
	public boolean isIsparent() {
		return isparent;
	}
	public void setIsparent(boolean isparent) {
		this.isparent = isparent;
	}

	
}

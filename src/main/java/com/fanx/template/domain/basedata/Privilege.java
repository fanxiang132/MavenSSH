package com.fanx.template.domain.basedata;

import java.io.Serializable;

/**
 * 权限表
 * 主目录的功能，及查询，删除，修改等
 * @author fanx
 *
 */
public class Privilege implements Serializable {

	private Long  id; //主键
	private String  name; //权限名称
	private Long  pid; //父
	private boolean  isparent; //是否是父类
	private String  ptype; //描述
	private String  icon; //图标
	private String  url;//访问action
	private boolean isdelete=false;//是否删除

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public boolean isIsparent() {
		return isparent;
	}
	public void setIsparent(boolean isparent) {
		this.isparent = isparent;
	}
	 
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public boolean isIsdelete() {
		return isdelete;
	}
	public void setIsdelete(boolean isdelete) {
		this.isdelete = isdelete;
	}
	
	
}

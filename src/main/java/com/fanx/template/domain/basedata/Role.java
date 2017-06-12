package com.fanx.template.domain.basedata;

import java.io.Serializable;
import java.util.Set;

/**
 * 角色表
 * @author fanx
 *
 */
public class Role implements Serializable {

	private Long rid;//id
	private String rolename;//角色名称
	private String description;//描述
	
	private Set<User> users;//用户
	
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
}

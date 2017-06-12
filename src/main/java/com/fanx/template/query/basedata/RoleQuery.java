package com.fanx.template.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.fanx.template.query.BaseQuery;

public class RoleQuery extends BaseQuery {

	private Long rid=0L;//id
	private String rolename;//角色名称
	
	@Override
	public Map<String, Object> buildWhere() {
		if(rid>0L){
			this.getKeyValues().put("rid", rid);
		}
		if(StringUtils.isNotBlank(rolename)){
			this.getKeyValues().put("rolename", rolename);
		}
		return this.getKeyValues();
	}

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

	
}

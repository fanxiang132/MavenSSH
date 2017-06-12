package com.fanx.template.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.fanx.template.query.BaseQuery;

public class UserQuery extends BaseQuery {

	private Long uid=0L;//id
	private String realname;//姓名
	private String username;//用户名
	private String password;//密码（MD5）
	private String token;//激活码
	
	
	public Long getUid() {
		return uid;
	}



	public void setUid(Long uid) {
		this.uid = uid;
	}



	public String getRealname() {
		return realname;
	}



	public void setRealname(String realname) {
		this.realname = realname;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	


	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	@Override
	public Map<String, Object> buildWhere() {
		if(uid>0L){
			this.getKeyValues().put("uid", uid);
		}
		if(StringUtils.isNotBlank(username)){
			this.getKeyValues().put("username", username);
		}
		if(StringUtils.isNotBlank(realname)){
			this.getKeyValues().put("realname",realname);
		}
		if(StringUtils.isNotBlank(password)){
			this.getKeyValues().put("password",password);
		}
		if(StringUtils.isNotBlank(token)){
			this.getKeyValues().put("token",token);
		}
		return this.getKeyValues();
	}

}

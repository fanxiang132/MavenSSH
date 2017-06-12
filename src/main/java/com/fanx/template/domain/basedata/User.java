package com.fanx.template.domain.basedata;

import java.io.Serializable;
import java.util.Set;

/**
 * 用户基础数据
 * @author fanx
 *
 */
public class User implements Serializable {

	private Long uid;//id
	private String realname;//姓名
	private String username;//用户名
	private String password;//密码（MD5）
	private String bodyid;//身份证
	private String age;//年龄
	private String birthday;//生日
	private String address;//地址
	private String email;//邮箱
	private String sex;//性别
	private String bodyimage;//身份证图片
	private boolean state;//是否在职
	private String token;//激活码
	private String sendtime;//发送时间
	private boolean isactivate;//是否激活
	private String addtime;//添加时间
	
	private Set<Role> roles;//角色集合
	
	
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
	public String getBodyid() {
		return bodyid;
	}
	public void setBodyid(String bodyid) {
		this.bodyid = bodyid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public boolean isIsactivate() {
		return isactivate;
	}
	public void setIsactivate(boolean isactivate) {
		this.isactivate = isactivate;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
	public String getBodyimage() {
		return bodyimage;
	}
	public void setBodyimage(String bodyimage) {
		this.bodyimage = bodyimage;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", realname=" + realname + ", username="
				+ username + ", password=" + password + ", bodyid=" + bodyid
				+ ", age=" + age + ", birthday=" + birthday + ", address="
				+ address + ", email=" + email + ", sex=" + sex + ", state="
				+ state + ", token=" + token + ", sendtime=" + sendtime
				+ ", isactivate=" + isactivate + ", addtime=" + addtime + "]";
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
}

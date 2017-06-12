package com.fanx.template.domain.basedata;

import java.io.Serializable;

/**
 * ip限制表
 * @author fanx
 *
 */
public class IPControl implements Serializable {

	private Long id;
	private String startIP;
	private String endIP;
	private String remark;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStartIP() {
		return startIP;
	}
	public void setStartIP(String startIP) {
		this.startIP = startIP;
	}
	public String getEndIP() {
		return endIP;
	}
	public void setEndIP(String endIP) {
		this.endIP = endIP;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "IPControl [id=" + id + ", startIP=" + startIP + ", endIP="
				+ endIP + "]";
	}
	
	
}

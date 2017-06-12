package com.fanx.template.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.fanx.template.query.BaseQuery;

public class IPControlQuery extends BaseQuery {

	private Long id=0L;//id
	private String startIP;//开始Ip
	private String endIP;//结束Ip
	private String remark;//备注
	@Override
	public Map<String, Object> buildWhere() {
		if(id>0L){
			this.getKeyValues().put("id", id);
		}
		if(StringUtils.isNotBlank(startIP)){
			this.getKeyValues().put("startIP", startIP);
		}
		if(StringUtils.isNotBlank(endIP)){
			this.getKeyValues().put("endIP", endIP);
		}
		if(StringUtils.isNotBlank(remark)){
			this.getKeyValues().put("remark", remark);
		}
		return this.getKeyValues();
	}
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

	 
	
}

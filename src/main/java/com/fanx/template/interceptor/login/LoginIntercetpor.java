package com.fanx.template.interceptor.login;

import java.util.Collection;

import org.apache.struts2.ServletActionContext;

import com.fanx.template.domain.basedata.IPControl;
import com.fanx.template.domain.basedata.User;
import com.fanx.template.service.basedata.IPControlService;
import com.fanx.template.service.impl.basedata.IPControlServiceImpl;
import com.fanx.template.utils.IPUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登陆拦截器
 * 
 * @author fanx
 * 
 */
public class LoginIntercetpor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		// 用户不存在
		if (user == null) {
			//判断IP是否允许访问
			if(IPcontrol()){
				return "login";
			}else{
				return "ipcontrol";
			}
		} else {
			return invocation.invoke();
		}
	}

	/**
	 * 判断IP是否受限
	 * @return
	 */
	private boolean IPcontrol() {
		// 获取客户端IP地址
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		boolean isIPc = false;
		// 查询ip的列表
		IPControlService ipControlService = new IPControlServiceImpl();
		Collection<IPControl> ips = ipControlService.findEntry();
		for (IPControl ipc : ips) {
			if (IPUtil.ipExistsInRange(ip.trim(), ipc.getStartIP().trim() + "-"
					+ ipc.getEndIP().trim())) {
				isIPc = true;
				break;
			}
		}
		return isIPc;
	}

}

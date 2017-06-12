package com.fanx.template.action.basedate;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fanx.template.base.action.BaseAction;
import com.fanx.template.domain.basedata.Privilege;
import com.fanx.template.service.basedata.PrivilegeService;
/**
 * 权限控制类
 * @author fanx
 *
 */
@Controller("PrivilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege> {

	@Resource(name="PrivilegeServiceImpl")
	private PrivilegeService privilegeService;
	
	/**
	 * 定位到
	 * @return
	 */
	public String listUI(){
		return "listUI";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		return ACTION2ACTION;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		return ACTION2ACTION;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		return ACTION2ACTION;
	}
}

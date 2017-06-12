package com.fanx.template.action.basedate;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fanx.template.base.action.BaseAction;
import com.fanx.template.domain.basedata.Department;
import com.fanx.template.service.basedata.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
/**
 * 部门组织结构action
 * @author fanx
 *
 */
@Controller("DepartmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

	@Resource(name="DepartmentServiceImpl")
	private DepartmentService departmentService;
	
	/**
	 * 部门组织列表
	 * @return
	 */
	public String listDepartment(){
		//获取所有组织结构
		Collection<Department> dps=departmentService.findEntry();
		ActionContext.getContext().getValueStack().push(dps);
		return SUCCESS;
	}
	
	/**
	 * 转到首页
	 * @return
	 */
	public String listUI(){
		return "listui";
	}
}

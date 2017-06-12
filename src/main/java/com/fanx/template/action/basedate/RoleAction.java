package com.fanx.template.action.basedate;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fanx.template.base.action.BaseAction;
import com.fanx.template.domain.basedata.Role;
import com.fanx.template.query.PageResult;
import com.fanx.template.query.basedata.RoleQuery;
import com.fanx.template.service.basedata.RoleService;
import com.opensymphony.xwork2.ActionContext;
/**
 * 角色控制类
 * @author fanx
 *
 */
@Controller("RoleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	@Resource(name="RoleServiceImpl")
	private RoleService roleService;
	
	private RoleQuery roleQuery = new RoleQuery();
	
	/**
	 * 角色列表UI
	 * @return
	 */
	public String listUI(){
		return "list";
	}
	
	/**
	 * 分页取所有角色数据
	 * @return
	 */
	public String findAllRolesByPages(){
		PageResult<Role> pgrs=roleService.findPageResult(roleQuery);
		ActionContext.getContext().put("roles", pgrs.getRows());
		return "list";
	}
	
	/**
	 * 删除角色
	 * @return
	 */
	public String dropRole(){
		return "delete";
	}
	
	/**
	 * 取得修改信息，跳转到修改UI
	 * @return
	 */
	public String updateIU(){
		return "updateIU";
	}
	
	/**
	 * 提交修改角色信息
	 * @return
	 */
	public String updateRole(){
		return "list";
	}
	
	/**
	 * 添加角色
	 * @return
	 */
	public String addRole(){
		Role role = new Role();
		try {
			BeanUtils.copyProperties(role, this.getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		roleService.saveEntry(role);
		return "addSuccess";
	}
	
	/**
	 * 添加角色
	 * @return
	 */
	public String addUI(){
		return "addUI";
	}

	
}

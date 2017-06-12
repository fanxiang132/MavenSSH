package com.fanx.template.action.basedate;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fanx.template.base.action.BaseAction;
import com.fanx.template.domain.basedata.IPControl;
import com.fanx.template.query.PageResult;
import com.fanx.template.query.basedata.IPControlQuery;
import com.fanx.template.service.basedata.IPControlService;
import com.opensymphony.xwork2.ActionContext;

/**
 * ip访问限制action
 * @author fanx
 *
 */
@Controller("IPControlAction")
@Scope("prototype")
public class IPControlAction extends BaseAction<IPControl> {

	@Resource(name="IPControlServiceImpl")
	private IPControlService ipControlService;
	
	private IPControlQuery ipControlQuery = new IPControlQuery();//分页查询数据
	private int currentPage;
	
	/**
	 * 添加界面
	 * @return
	 */
	public String addUI(){
		return ADDUI;
	}
	
	/**
	 * 修改界面
	 * @return
	 */
	public String updateUI(){
		return UPDATEUI;
	}
	
	/**
	 * 添加IP
	 * @return
	 */
	public String addIP(){
		IPControl ipControl = new IPControl();
		try {
			BeanUtils.copyProperties(ipControl, this.getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ipControlService.saveEntry(ipControl);
		return ACTION2ACTION;
	}
	
	/**
	 * 修改IP
	 * @return
	 */
	public String updateIP(){
		IPControl ipControl = new IPControl();
		try {
			BeanUtils.copyProperties(ipControl, this.getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ipControlService.updateEntry(ipControl);
		return ACTION2ACTION;
	}
	
	/**
	 * 删除IP
	 * @return
	 */
	public String deleteIP(){
		//删除类
		ipControlService.deleteEntry(this.getModel().getId());
		return ACTION2ACTION;
	}
	
	/**
	 * 分页查询所有ip限制
	 * @return
	 */
	public String findAll(){
		ipControlQuery.setCurrentPage(currentPage);
		PageResult<IPControl> ips = ipControlService.findPageResult(ipControlQuery); 
		ActionContext.getContext().put("ips", ips.getRows());
		return SUCCESS;
	}

	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}

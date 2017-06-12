package com.fanx.template.action.basedate;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fanx.template.base.action.BaseAction;
import com.fanx.template.domain.basedata.Position;
import com.fanx.template.service.basedata.PositionService;
/**
 * 职位控制类
 * @author fanx
 *
 */
@Controller("PositionAction")
@Scope("prototype")
public class PositionAction extends BaseAction<Position> {

	@Resource(name="PositionSerivceImpl")
	private PositionService positionService;
	
	/**
	 * 添加页面
	 * @return
	 */
	public String addUI(){
		return ADDUI;
	}
	

	/**
	 * 添加职务
	 * @return
	 */
	public String addPosition(){
		Position position = new Position();
		try {
			BeanUtils.copyProperties(position, this.getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ACTION2ACTION;
	}
	
	/**
	 * 修改职务
	 * @return
	 */
	public String updatePosition(){
		Position position = new Position();
		try {
			BeanUtils.copyProperties(position, this.getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ACTION2ACTION;
	}
	
	
	
	/**
	 * 修改界面
	 * @return
	 */
	public String updateUI(){
		return UPDATEUI;
	}
	
	/**
	 * 删除职务，逻辑删除
	 * @return
	 */
	public String deletePosition(){
		//物理删除
		return ACTION2ACTION;
	}
}

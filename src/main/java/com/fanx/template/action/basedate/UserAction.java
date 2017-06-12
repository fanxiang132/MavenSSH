package com.fanx.template.action.basedate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;

import com.fanx.template.base.action.BaseAction;
import com.fanx.template.domain.basedata.BaseDomain;
import com.fanx.template.domain.basedata.User;
import com.fanx.template.query.PageResult;
import com.fanx.template.query.basedata.UserQuery;
import com.fanx.template.service.basedata.UserService;
import com.fanx.template.utils.EmailUtil;
import com.fanx.template.utils.LoggerUtils;
import com.fanx.template.utils.MD5Util;
import com.opensymphony.xwork2.ActionContext;

/**
 * 用户控制类
 * @author fanx
 *
 */
@Controller("UserAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6342480696104747860L;
	@Resource(name="UserServiceImpl")
	private UserService userService;
	//邮件处理
	@Resource(name="mailSender")
	private MailSender sender;
	@Resource(name="mailMessage")
	private SimpleMailMessage mailMessage;
	
	private String checkcode;//验证码
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public String listAllUser(){
		return "list";
	}
	
	/**
	 * 找用户根据id
	 * @return
	 */
	public String findUserById(){
		return "update";
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	public String registUser(){
		final User user  = new User();
		try {
			BeanUtils.copyProperties(user, this.getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//密码设置MD5
		user.setPassword(MD5Util.Md5(user.getPassword()));
		user.setState(true);//是否在职
		//获取时间撮加密
		String token = MD5Util.Md5(System.currentTimeMillis()+""+user.getUsername());
		user.setToken(token);//激活码
		user.setSendtime(System.currentTimeMillis()+"");//激活码发送时间
		user.setIsactivate(false);//是否激活
		user.setAddtime(System.currentTimeMillis()+"");//用户添加时间
		LoggerUtils.sLog(user.toString());
		userService.saveEntry(user);
		//添加成功后发送激活邮件去激活
		final String url="http://localhost:8080/TemplateMavenSSH/user_activityUser.action?token="+token;
		//开个 子线程去发送邮件
		new Thread(){
			public void run() {
				EmailUtil.sendEmail(user.getEmail(), sender, mailMessage, "你注册了****系统，点击链接完成注册:"+url+"      <a href="+url+">激活账户</a>", "系统注册激活");
			};
		}.start();
		//判断这个邮箱的类型
		String urltype = EmailUtil.getEmailURL(user.getEmail());
		ActionContext.getContext().put("urltype", urltype);;
		return "addSuc";
	}
	
	/**
	 * 登录action
	 */
	public String loginUser(){
		String username = this.getModel().getUsername();
		String password = this.getModel().getPassword();
		//建立查询
		UserQuery query =new UserQuery();
		query.setUsername(username);
		query.setPassword(password);
		PageResult<User> users=userService.findPageResult(query);
		List<User> us=users.getRows();
		//返回结果对象
		BaseDomain baseDomain=null;
		if(us.size()==0||us==null){
			baseDomain = new BaseDomain();
			baseDomain.setCode(5);
			
		}else{
			baseDomain = new BaseDomain();
			User user = us.get(0);
			//判断是否邮箱激活
			if(user.isIsactivate()){
				//判断是否在职
				if(user.isState()){
					//登陆成功加入session
					ServletActionContext.getRequest().getSession().setAttribute("user",user);
					baseDomain.setCode(0);
				}else{
					//用户已离职
					baseDomain.setCode(7);
				}
			}else{
				//没有激活
				baseDomain.setCode(6);
			}
		}
		//返回值
		ActionContext.getContext().getValueStack().push(baseDomain);
		return SUCCESS;
		
	}

	/**
	 * 激活用户
	 */
	public String activityUser(){
		//取得邮箱中地址返回的token
		String token=this.getModel().getToken();
		//根据token查询用户
		UserQuery query =new UserQuery();
		query.setToken(token);
		PageResult<User> users=userService.findPageResult(query);
		List<User> us=users.getRows();
		BaseDomain dBaseDomain = new BaseDomain();
		if(us.size()==0){//激活码不存在
			dBaseDomain.setCode(2);
		}else{//存在
			User user = us.get(0);
			boolean isa=user.isIsactivate();
			if(isa){//已完成激活
				dBaseDomain.setCode(3);
			}else{
				//取得发送时间判断是否超过激活时间了
				Long sendtime = Long.parseLong(user.getSendtime());
				Long thistime = System.currentTimeMillis();
				Long s = (thistime-sendtime)/1000;
				if(s>60*60*24){//超时了
					dBaseDomain.setCode(4);
					dBaseDomain.setOb(user.getUid());
				}else{
					//设置激活成功
					user.setIsactivate(true);
					//保存
					userService.saveEntry(user);
					dBaseDomain.setCode(0);
				}
			}
		}
		ActionContext.getContext().put("dBaseDomain",dBaseDomain);
		return "activitySuc";
	}
	
	/**
	 * 跳转登录页面
	 * @return
	 */
	public String loginUI(){
		return "loginUI";
	}
	
	/**
	 * 发送激活邮件
	 * @return
	 */
	public String reSendEmail(){
		//取得邮箱
		String uid = this.getModel().getEmail();
		return "";
	}
	
	
	
	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	/**
	 * 根据用户id再次发送激活邮件
	 * @param uid
	 */
	private void sendEmailByUid(String uid){
		//查询用户信息
	}
}

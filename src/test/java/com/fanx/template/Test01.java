package com.fanx.template;

import org.junit.Test;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.fanx.template.domain.basedata.Department;
import com.fanx.template.service.basedata.DepartmentService;
import com.fanx.template.utils.EmailUtil;
import com.fanx.template.utils.IPUtil;
import com.fanx.template.utils.MD5Util;

public class Test01 extends SpringUtils {

	@Test
	public void Test1() {
		System.out.println(MD5Util.Md5("0123456789"));
	}

	@Test
	public void sendEmail() {

		MailSender sender = (MailSender) aContext.getBean("mailSender");
		SimpleMailMessage mailMessage = (SimpleMailMessage) aContext
				.getBean("mailMessage");
		mailMessage.setSubject("系统注册验证");
		mailMessage.setText("这个是一个通过Spring框架来发送邮件的小程序");
		mailMessage.setTo("921495007@qq.com");
		sender.send(mailMessage);
	}

	@Test
	public void testIP() {
		String ip = "10.10.10.116";

		String ipSection = "10.10.1.00-10.10.1.255";

		boolean exists = IPUtil.ipExistsInRange(ip, ipSection);

		System.out.println(exists);

		System.out.println(IPUtil.getIp2long(ip));

		System.out.println(IPUtil.getIp2long2(ip));

	}

	@Test
	public void emailjiequ() {
		String uty = EmailUtil.getEmailURL("921495007@qq.com");
		System.out.println("返回的值=" + uty);
	}
	
	@Test
	public void adddepartment() {
		DepartmentService dService = (DepartmentService) aContext.getBean("DepartmentServiceImpl");
		Department department = new Department("集团", 0L, true, "最顶级组织结构","images/003.gif");
		dService.saveEntry(department);
	}
}

package com.fanx.template.utils;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * 发送邮件
 * 
 * @author fanx
 * 
 */
public class EmailUtil {

	/**
	 * 发送激活邮件
	 * @param email 地址
	 * @param sender 
	 * @param mailMessage
	 * @param content 内容
	 * @param title 标题
	 */
	public static void sendEmail(String email,MailSender sender,SimpleMailMessage mailMessage,String content,String title){
		mailMessage.setSubject(title);
		mailMessage.setText(content);
		mailMessage.setTo(email);
		sender.send(mailMessage);
	}
	
	/**
	 * 根据邮箱找到地址
	 * @param email
	 * @return
	 */
	public static  String  getEmailURL(String email) {
		// 截取尾部
		String weim = email.substring(email.lastIndexOf("@")+1, email.length());
		System.out.println("截取的值="+weim);
		if ("163.com".equals(weim)) {
			return "mail.163.com";
		} else if ("vip.163.com".equals(weim)) {
			return "vip.163.com";
		} else if ("126.com".equals(weim)) {
			return "mail.126.com";
		} else if ("qq.com".equals(weim) || "vip.qq.com".equals(weim)
				|| "foxmail.com".equals(weim)) {
			return "mail.qq.com";
		} else if ("gmail.com".equals(weim)) {
			return "mail.google.com";
		} else if ("sohu.com".equals(weim)) {
			return "mail.sohu.com";
		} else if ("tom.com".equals(weim)) {
			return "mail.tom.com";
		} else if ("vip.sina.com".equals(weim)) {
			return "vip.sina.com";
		} else if ("sina.com.cn".equals(weim) || "sina.com".equals(weim)) {
			return "mail.sina.com.cn";
		} else if ("tom.com".equals(weim)) {
			return "mail.tom.com";
		} else if ("yahoo.com.cn".equals(weim) || "yahoo.cn".equals(weim)) {
			return "mail.cn.yahoo.com";
		} else if ("tom.com".equals(weim)) {
			return "mail.tom.com";
		} else if ("yeah.net".equals(weim)) {
			return "www.yeah.net";
		} else if ("21cn.com".equals(weim)) {
			return "mail.21cn.com";
		} else if ("hotmail.com".equals(weim)) {
			return "www.hotmail.com";
		} else if ("sogou.com".equals(weim)) {
			return "mail.sogou.com";
		} else if ("188.com".equals(weim)) {
			return "www.188.com";
		} else if ("139.com".equals(weim)) {
			return "mail.10086.cn";
		} else if ("189.cn".equals(weim)) {
			return "webmail15.189.cn/webmail";
		} else if ("wo.com.cn".equals(weim)) {
			return "mail.wo.com.cn/smsmail";
		} else if ("139.com".equals(weim)) {
			return "mail.10086.cn";
		} else {
			return "";
		}
	}
}

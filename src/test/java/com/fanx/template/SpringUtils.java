package com.fanx.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {

	public static ApplicationContext aContext;
	static{
		aContext = new  ClassPathXmlApplicationContext("com/fanx/template/applicationContext.xml");
	}
}

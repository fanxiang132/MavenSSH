package com.fanx.template;

import java.applet.AppletContext;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class AddBean extends SpringUtils{

	@Test
	public void add(){
		SessionFactory sessionFactory=(SessionFactory) aContext.getBean("sessionFactory");
	}
	
}

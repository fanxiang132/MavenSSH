package com.fanx.template.utils;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;



public class LoggerUtils {

	private static Logger logger = Logger.getLogger(LoggerUtils.class);
	
	public static void sLog(String lcontent){
		logger.info(lcontent);
	}
}

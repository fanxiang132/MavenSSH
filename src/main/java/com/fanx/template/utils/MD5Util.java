package com.fanx.template.utils;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * MD5辅助类
 * @author fanx
 *
 */
public class MD5Util {
	public static  String Md5(String msg){
		  try {
			   MessageDigest md = MessageDigest.getInstance("md5");
			   byte md5[] = md.digest(msg.getBytes("UTF-8"));
			   return MyBase64.encode(md5);//解释md5码成明文字符串
		  } catch (Exception e) {
			   throw new RuntimeException(e);
		  }
	}
}

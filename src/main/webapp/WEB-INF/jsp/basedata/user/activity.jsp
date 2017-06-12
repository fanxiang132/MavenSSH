<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>激活页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     	<s:if test="#dBaseDomain.code==0">
     		激活成功，<a href="user_loginUI.action">登陆</a>
     	</s:if>
     	<s:elseif test="#dBaseDomain.code==1">
     		激活失败<a href="user_loginUI.action">登陆</a>
     	</s:elseif>
     	<s:elseif test="#dBaseDomain.code==2">
     		激活码不存在<a href="user_loginUI.action">登陆</a>
     	</s:elseif>
     	<s:elseif test="#dBaseDomain.code==3">
     		已经激活了<a href="user_loginUI.action">登陆</a>
     	</s:elseif>
     	<s:elseif test="#dBaseDomain.code==4">
     		超过激活时间了<a href="user_reSendEmail.action?email=${dBaseDomain.ob} }">再次发送激活数据</a>
     	</s:elseif>
  </body>
</html>

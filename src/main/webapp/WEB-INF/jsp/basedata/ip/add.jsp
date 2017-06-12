<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加IP访问限制</title>
    
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
      <div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加IP访问权限</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="visitip_addIP.action">  
       <div class="form-group">
        <div class="label">
          <label>IP开始：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="startIP" data-validate="required:请输入开始IP" /> 
          <div class="tips"></div>
        </div>
       </div>
        <div class="form-group">
        <div class="label">
          <label>IP结束：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="endIP" data-validate="required:请输入结束IP" /> 
          <div class="tips"></div>
        </div>
       </div>
     <div class="form-group">
        <div class="label">
          <label>备注：</label>
        </div>
        <div class="field">
          <textarea  type="text" class="input w50" value="" name="remark" style="height:100px; border:1px solid #ddd;" data-validate="required:请输入备注" ></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
      </div>
     </form>
     </div>
     </div>
</div>
  </body>
</html>

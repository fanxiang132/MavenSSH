<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>部门结构</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script language="javascript" src="js/jquery-1.8.3.min.js"></script>
	<script language="javascript" src="js/jquery-ztree-2.5.js"></script>
	<script language="javascript" src="js/department.js"></script>

  </head>
  
  <body>
       <TABLE border=0 height=600px align=left>
		<TR>
			<TD width=230px align=left valign=top>
				<ul id="departmentTree" class="tree" style="width:230px; overflow:auto;"></ul>
			</TD>
		</TR>
	</TABLE>
	<!-- 右击部门显示的三个功能 -->
	<div class="addnodes" id="rMenu" style="position:absolute;display:none;overflow:hidden">
       <ul>
         <li id="addDepartment" style="background: url(style/images/jia.jpg) 10px 5px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">增加部门</li>
         <li id="deleteDepartment" style="background: url(style/images/jian.jpg) 10px 9px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">删除部门</li>
         <li id="updateDepartment" style="background: url(style/images/jian.jpg) 10px 9px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">修改部门</li>
       </ul>
	</div>
	
	<!-- 点击添加部门显示的div -->
	<div id="adddepartment"  style="display:none;">
		部门名称：<input type="text" class="input w50" value="" name="dname" data-validate="required:请输入开始IP" /> <br/>
		部门描述： <textarea  type="text" class="input w50" value="" name="remark" style="height:100px; border:1px solid #ddd;" data-validate="required:请输入地址" ></textarea><br/>
	    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        
	</div>
  </body>
</html>

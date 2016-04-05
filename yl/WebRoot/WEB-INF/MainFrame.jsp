<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    

  </head>
  
 <body>

   <h2>欢迎 ${user.name }，您所在的部门是${ user.department.name}
<br/>请选择您要进行的操作</h2>

	<table>
	<tr><td><a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=addUi">添加雇员</a></td></tr>
	<tr><td><a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=showUi&page=1">查看雇员</a></td></tr>
	<tr><td><a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=gotoSeekUi">查找雇员</a></td></tr>
	<tr><td><a href="<%=this.getServletContext().getContextPath() %>/login.do?flag=loginOut">退出系统</a></td></tr>
</table>
  </body>
</html>


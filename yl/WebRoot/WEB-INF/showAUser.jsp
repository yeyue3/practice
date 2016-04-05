<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    

  </head>
  
 <body>
   <h2>雇员信息</h2><a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=gotoModifyUi&id=${seekEmp.id}">修改雇员</a>
	<a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=gotoMainUi">返回主界面</a>

<table>
<tr><td>name</td><td>${seekEmp.name}</td></tr>
<tr><td>email</td><td>${seekEmp.email}</td></tr>
<tr><td>grade</td><td>${seekEmp.grade}</td></tr>
</table>
  </body>
</html>
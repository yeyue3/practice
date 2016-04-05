<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    

  </head>
  
 <body>
    <h1>管理员登录</h1>
	<form action="<%=this.getServletContext().getContextPath() %>/login.do?flag=login" method="post">
	<table>
	<tr><td>用户名</td><td><input type="text" name="id" style="width: 130px"/></td></tr>
	<tr><td>密　码</td><td><input type="password" name="pwd" style="width: 130px"/></td></tr>
	<tr><td><input type="submit" value="登录" /></td><td><input type="reset" value="重新填写"/></td></tr>
	</table>
	</form>
  </body>
</html>


<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    

  </head>
  
 <body>
   <h2>查找用户</h2><a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=gotoMainUi">返回主界面</a><br/>
<form action="<%=this.getServletContext().getContextPath() %>/employee.do?flag=seek" method="post">
	<h3>请输入您要查找的用户id</h3><input name="id" type="text"/><br/>
	<input type="submit" value="确定"/>

</form>
  </body>
</html>
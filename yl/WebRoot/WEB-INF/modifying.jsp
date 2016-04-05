<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    

  </head>
  
 <body>
   <h2>用户信息</h2>　　　<a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=gotoMainUi">返回主界面</a><br/>
	<form action="/yl/employee.do?flag=modify" method="post">
<table>
<tr><td>id</td><td><input type="text" readonly="readonly" name="id" value=${employee.id}></td></tr>
<tr><td>name</td><td><input type="text" name="name" value=${employee.name}></td></tr>
<tr><td>email</td><td><input type="text" name="email" value=${employee.email}></td></tr>
<tr><td>salary</td><td><input type="text" name="salary" value=${employee.salary}></td></tr>
<tr><td><input type="submit" value="确认修改"/></td><td><input type="reset" value="重置"></td></tr>
</table>
</form>
  </body>
</html>
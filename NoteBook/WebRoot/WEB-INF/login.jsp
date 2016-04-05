<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  

  <body>
    <h1>登陆界面</h1>
	<form action="/NoteBook/login.do?flag=login" method="post">
	<table>
	<tr><td>用户id</td><td><input type="text" name="userid" /></td></tr>
	<tr><td>密　码</td><td><input type="password" name="pwd" /></td></tr>
	<tr><td><input type="submit" value=登录 /></td><td></td></tr>
	</table>
	</form>
  </body>
</html>


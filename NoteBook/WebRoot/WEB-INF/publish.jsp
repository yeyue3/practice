<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'mainView.jsp' starting page</title>


  </head>
  
  <body>
<font size="6"><a href="">查看信息</a><a href="/NoteBook/login.do?flag=loginOut">退出登陆</a></font><br/>
<form action="/NoteBook/goPublish.do?flag=publish" method="post">
<table>
<tr><td>接收人 </td><td><input type="text" name="getterName"></input></td></tr>
<tr><td>发送内容</td><td><textarea rows="5" cols="20" name="content">请输入内容</textarea></td></tr>
<tr><td><input type="submit" value="发布" /></td><td><input type="reset" value="重新填写" /></td></tr>
</table>
</form>
  </body>
</html>

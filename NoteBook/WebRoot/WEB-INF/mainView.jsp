<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'mainView.jsp' starting page</title>


  </head>
  
  <body>
  <h1>主界面</h1>
欢迎你，${userInfo.username}！<br/>

<a href="<%=this.getServletContext().getContextPath()%>/goPublish.do?flag=goPublish">发布信息 </a><a href="/NoteBook/login.do?flag=loginOut">退出系统</a><br/><br/>
留言信息<br/>
<table border='1px' width='500px'>
<tr><td>信息号</td><td>发送人</td><td>接收人</td><td>内容</td><td>发送时间</td></tr>
	<c:forEach items="${chat}" var="achat">
<tr><td>${achat.id}</td><td>${achat.sender.username }</td><td>${achat.getter.username }</td><td>${achat.content}</td><td>${achat.transtime}</td></tr>
	</c:forEach>
</table>
  </body>
</html>

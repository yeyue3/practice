<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



<html>
<script type="text/javascript">
function sureDelete(){
	return window.confirm("确定要删除该雇员吗");
}
</script>

  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    

  </head>
  
 <body>
   <h2>雇员列表</h2><a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=gotoMainUi">返回主界面</a>
<table border="1px">
<tr><td width="80px">name</td><td width="80px">email</td><td width="80px">salary</td><td>修改雇员</td><td>删除雇员</td></tr>
	<c:forEach items="${list}" var="employee">
	<tr><td><c:out value="${employee.name}"/></td><td><c:out value="${employee.email}"/></td><td><c:out value="${employee.salary}"/></td>
<td><a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=gotoModifyUi&id=${employee.id}">修改雇员</a></td>
<td><a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=delete&id=${employee.id}" onclick="return sureDelete()">删除雇员</a></td>
</tr>
</c:forEach>
</table>
<c:forEach var="i" begin="1" end="${pageCount}">
<a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=showUi&page=${i }">${i }</a>
</c:forEach>

  </body>
</html>

<!--  <%int pageCount=(Integer)request.getAttribute("pageCount"); 
for(int i=1; i<=pageCount; i++){
%>
<a href="/yl/employee.do?flag=showUi&page=<%=i %>"><%=i%></a>
<%}%>
-->
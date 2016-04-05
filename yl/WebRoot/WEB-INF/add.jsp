<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    

  </head>
  
 <body>
   <h1>添加雇员</h1><a href="<%=this.getServletContext().getContextPath() %>/employee.do?flag=gotoMainUi">返回主界面</a>
<form action="<%=this.getServletContext().getContextPath() %>/employee.do?flag=add" method="post">
<table>
<tr><td>name</td><td><input type="text" name="name" style="width: 130px"/></td></tr>
<tr><td>email</td><td><input type="text" name="email" style="width: 130px"/></td></tr>
<tr><td>salary</td><td><input type="text" name="salary" style="width: 130px"/></td></tr>
<tr><td>pwd</td><td><input type="text" name="pwd" style="width: 130px"/></td></tr>
<tr><td>grade</td><td><input type="text" name="grade" style="width: 130px"/></td></tr>
<tr><td>department</td>
<td><select name="department">
<option value="1" selected="selected">技术部</option>
<option value="2">财务部</option>
</select>
</td></tr>
<tr><td><input type="submit" value="提交"/></td><td><input type="reset" value="重新填写"/></td></tr>
</table>
</form>
  </body>
</html>


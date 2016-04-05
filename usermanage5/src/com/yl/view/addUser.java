package com.yl.view;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class addUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script type='text/javascript'>");
		out.println("function checkInfo(){");
		out.println("span1.innerText='';");
		out.println("span2.innerText='';");
		out.println("span3.innerText='';");
		out.println("span4.innerText='';");
		out.println("span5.innerText='';");
		out.println("boolean res=true;");
		out.println("if(document.form[0].id.value==null) {span1.innerText='id不能为空';res=false;System.out.println('oo');}");
		out.println("return res;");
		out.println("}");
		out.println("</script>");
		
		out.println("<img src='images/1.jpg' width=130px height=80px/>");

		out
				.println("<form action='/usermanage4/ChangeClServlet' method='post' onsubmit='return checkInfo()'>"
						+ "<table>"
						+ "<tr><td style='width:80px'>用户id</td><td><input type='text' name='id'/><span id='span1'></td></tr>"
						+ "<tr><td>用户名</td><td><input type='text' name='username'/><span id='span2'></td></tr>"
						+ "<tr><td>email</td><td><input type='text' name='email'/><span id='span3'></td></tr>"
						+ "<tr><td>级别</td><td><input type='text' name='grade'/><span id='span4'></td></tr>"
						+"<tr><td>密码</td><td><input type='text' name='password'/><span id='span5'></td></tr>"
						+ "</table>"

						+ "<input type='hidden' name='type' value='add' />");
		out.println("<input type='submit' value='确认添加'/>" + "</form>");

		out.println("<img src='images/2.jpg' width=130px height=80px/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}

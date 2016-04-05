package com.yl.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.service.*;
import com.yl.domian.Users;

public class ManageUsers extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		UserService us = new UserService();

		out.println("<script language='javascript'>");
		out
				.println("function pageTo(){"
						+ "window.open('/usermanage4/ManageUsers?"
						+ "pageNow='+document.getElementById(\"pageTo\").value,'_self')"
						+ "}");
		
		out.println("function delConfirm(){" +
				"return window.confirm('ȷ��Ҫɾ�����û���')"+	
		"}");
		
		out.println("</script>");

		out.println("<img src='images/1.jpg' width=130px height=80px/>");
		out.println("<h1>�����û�</h1>");

		int pageNow = 1;
		int pageSize = 3;
		int pageCount = us.page(pageSize);

		String pn = request.getParameter("pageNow");

		if (pn != null) {
			pageNow = Integer.parseInt(pn);
		}

		out.println("<table border=1px bordercolor=green>");
		out
				.println("<tr><th>id</th><th>�û���</th><th>email</th><th>����</th><th>ɾ���û�</th><th>�޸��û�</th></tr>");

		ArrayList<Users> al = us.getUserByPage(pageNow, pageSize);
		for (Users user : al) {
			out.println("<tr><td>" + user.getId() + "<td>" + user.getUsername()
					+ "</td><td>" + user.getEmail() + "</td>" + "<td>"
					+ user.getGrade()+"</td>" +
					"<td><a href='/usermanage4/ChangeClServlet?type=del&id="+ user.getId()+"' onclick='return delConfirm()'>ɾ���û�</a></td>" +
					"<td><a href='/usermanage4/ChangeClServlet?type=chan&id="+user.getId()+"'>�޸��û�</a></td></tr>");
		}
		out.println("</table>");
		out.println("<br/>");

		if (pageNow != 1) {
			out.println("<a href='/usermanage4/ManageUsers?pageNow="
					+ (pageNow - 1) + "'>��һҳ</a>");
		}
		for (int i = 1; i <= pageCount; i++) {
			out.println("<a href='/usermanage4/ManageUsers?pageNow=" + i
					+ "'><" + i + "></a>");
		}
		if (pageNow != pageCount) {
			out.println("<a href='/usermanage4/ManageUsers?pageNow="
					+ (pageNow + 1) + "'>��һҳ</a>");
		}
		out.println("&nbsp;&nbsp;&nbsp;��ǰҳ" + pageNow + "/��ҳ��" + pageCount);

		out
				.println("<br/>��ת��<input type='text' id='pageTo' name='pageTo' style='width:60px'/>"
						+ " <input type='button' value='��' onclick='pageTo()'/><br/>");
		
		out.println("<a href='/usermanage4/MainView'>��ת��������");
		out.println("<br/><img src='images/2.jpg' width=130px height=80px/>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}

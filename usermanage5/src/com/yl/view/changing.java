package com.yl.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.domian.Users;
import com.yl.service.UserService;
import com.yl.util.SqlHelper;

public class changing extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String id = (String) request.getAttribute("id");
		UserService us = new UserService();
		Users user = us.presentUser(id);

		out
				.println("<form action='/usermanage4/ChangeClServlet' method='post'>"
						+ "<table>"
						+ "<tr><td style='width:80px'>用户id</td><td><input type='text' name='id' value='"
						+ user.getId()
						+ "' readonly='readonly'/></td></tr>"
						+ "<tr><td>用户名</td><td><input type='text' name='username' value='"
						+ user.getUsername()
						+ "'/></td></tr>"
						+ "<tr><td>email</td><td><input type='text' name='email' value='"
						+ user.getEmail()
						+ "'/></td></tr>"
						+ "<tr><td>级别</td><td><input type='text' name='grade' value='"
						+ user.getGrade()
						+ "'/></td></tr>"
						+ "</table>"
		
						+ "<input type='hidden' name='type' value='chan2' />");
		String err=(String) request.getAttribute("err");
		if (err != null) {
			out.println(err);
		}
		out.println("<input type='submit' value='确认修改'/>" + "</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}

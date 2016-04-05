package com.yl.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yl.controler.*;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String nameCookie = "";
		String pwdCookie = "";

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("id".equals(cookie.getName())) {
					nameCookie = cookie.getValue();
				}
				if ("password".equals(cookie.getName())) {
					pwdCookie = cookie.getValue();
				}
			}
		}

		out.println("<img src='images/1.jpg' width=130px height=80px/>");

		out.println("<h1>用户登陆</h1>");
		out.println("<form action='/usermanage4/LoginCheck' method='get'>");
		out.println("用户id<input type='text' name='id' value='" + nameCookie
				+ "'/><br/>");
		out.println("密　码<input type='password' name='password' value='"
				+ pwdCookie + "'/><br/>");
		out.println("<input type='checkbox' name='rember'/>记住用户名及密码<br/>");
		out.println("<input type='submit' value='登录'/>");
		out.println("</form>");
		if (request.getAttribute("err") != null) {
			out.println(request.getAttribute("err").toString() + "<br/>");
		}

		out.println("<img src='images/2.jpg' width=130px height=80px/>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}

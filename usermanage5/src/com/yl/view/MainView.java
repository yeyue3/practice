package com.yl.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MainView extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("login") == null){
			request.setAttribute("err", "请先登录");
			 request.getRequestDispatcher("/Login").forward(request, response);
			 return;
		}
		
		out.println("<img src='images/1.jpg' width=130px height=80px/>欢迎"+request.getAttribute("username")+"登录" );
		Cookie[] cookies = request.getCookies();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = simpleDateFormat.format(new Date());
		boolean res = false;
		if(cookies != null){
			for(Cookie mycookie : cookies){
				if("lastLoginTime".equals(mycookie.getName())){
					out.println("您上一次的登陆时间为"+mycookie.getValue());
					mycookie.setValue(nowTime);
					mycookie.setMaxAge(3600);
					response.addCookie(mycookie);
					res = true;
					break;
				}
			}
		}
		if(!res){
			Cookie cookie = new Cookie("lastLoginTime",nowTime);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		
		ServletContext sc = this.getServletContext();
		out.println("访问次数"+(String)sc.getAttribute("visitTime"));
		
				out.println("<a href='/usermanage4/Login'>返回登陆界面</a><br/>");
		
		out.println("<a href='/usermanage4/ManageUsers'>管理用户</a><br/>");
		out.println("<a href='/usermanage4/addUser'>添加用户</a><br/>");
		out.println("<a href='/usermanage4/ManageUsers'>查找用户</a><br/>");
		out.println("<a href='/usermanage4/ManageUsers'>退出系统</a><br/>");
		
		out.println("<img src='images/2.jpg' width=130px height=80px/>");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}

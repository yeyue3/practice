package com.yl.controler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yl.domian.Users;
import com.yl.service.UserService;

public class LoginCheck extends HttpServlet {
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
		String path = this.getServletContext().getRealPath("visitTime.txt");
		try {
			FileWriter fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);
			
			ServletContext sc = this.getServletContext();
			String time = (String) sc.getAttribute("visitTime");
			bw.write(time);
			
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		 String id = request.getParameter("id");
		 String password = request.getParameter("password");
		 
		 Users user = new Users();
		 user.setId(Integer.parseInt(id));
		 user.setPassword(password);
		 
		 if("on".equals(request.getParameter("rember"))){
			 Cookie cookie = new Cookie("id",id);
				cookie.setMaxAge(7*3600);
				response.addCookie(cookie);
				
				Cookie cookie2 = new Cookie("password",password);
				cookie.setMaxAge(7*3600);
				response.addCookie(cookie2);
		 }/*else{//我这里设置的是如果记住密码登录时没有再次勾选，cookies会消失，不合实际吧，暂时去掉了
			 Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if ("id".equals(cookie.getName())) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
						if ("password".equals(cookie.getName())) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					}
				}
		 }*/
		 
		 if(id != null && password != null && UserService.checkInfo(user)){
			 
			 HttpSession session = request.getSession();
			 session.setAttribute("login", user);
			 
			 ServletContext sc = this.getServletContext();
			 String time = (String) sc.getAttribute("visitTime");
			 sc.setAttribute("visitTime", (Integer.parseInt(time)+1)+"");
			 
			 request.setAttribute("username", user.getNameById(id));
			 request.getRequestDispatcher("/MainView").forward(request, response);
			 
			 
		 }else{
			 request.setAttribute("err","用户id或密码错误");
			 request.getRequestDispatcher("/Login").forward(request, response);
			}
		 
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	 public void init() throws ServletException {
			String path = this.getServletContext().getRealPath("visitTime.txt");
			
			try {//疑问，那每次读取写入后原来的值去哪了，而且为嘛俩文件不匹配？
				FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);
				String time = br.readLine();
				if(time == null){
					time = "0";
				}
				ServletContext sc = this.getServletContext();
				sc.setAttribute("visitTime", time);
				
				fr.close();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

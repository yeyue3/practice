package com.yl.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yl.domian.Users;
import com.yl.service.UserService;

public class ChangeClServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		UserService us = new UserService();

		if ("del".equals(request.getParameter("type"))) {
			String id = request.getParameter("id");
			
			request.setAttribute("scene", "删除");
			if (us.delUser(id)) {
				request.getRequestDispatcher("/sucess").forward(request,
						response);
			} else {
				request.getRequestDispatcher("/failed").forward(request,
						response);
			}
		} else if ("chan".equals(request.getParameter("type"))) {
			request.setAttribute("id", request.getParameter("id"));
			request.getRequestDispatcher("/changing")
					.forward(request, response);
		} else if ("chan2".equals(request.getParameter("type"))) {
			Users user = new Users();
			user.setId(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("id", user.getId()+"");
			
			if (request.getParameter("username") != null
					&& !request.getParameter("username").equals("")) {
				user.setUsername((request.getParameter("username")));
			}else{
				request.setAttribute("err", "username不可为空");
				request.getRequestDispatcher("/changing").forward(request, response);
				return;
			}
			if (request.getParameter("email") != null
					&& !request.getParameter("email").equals("")) {
				user.setEmail(request.getParameter("email"));
				
			}else{
				request.setAttribute("err", "email不可为空");
				request.getRequestDispatcher("/changing").forward(request, response);
				return;
			}
			if (request.getParameter("grade") != null
					&& !request.getParameter("grade").equals("")) {
				user.setGrade(Integer.parseInt(request.getParameter("grade")));
			}else{
				request.setAttribute("err", "grade不可为空");
				request.getRequestDispatcher("/changing").forward(request, response);
				return;
			}
			request.setAttribute("scene", "修改");
			if(us.changeUser(user,user.getId())){
				request.getRequestDispatcher("/sucess").forward(request, response);
			}else{
				request.getRequestDispatcher("/failed").forward(request, response);
			}
		} else if ("add".equals(request.getParameter("type"))) {
			Users user = new Users();
			user.setId(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("id", user.getId()+"");
			if (request.getParameter("username") != null
					&& !request.getParameter("username").equals("")) {
				user.setUsername((request.getParameter("username")));
			}else{
				request.setAttribute("err", "username不可为空");
				request.getRequestDispatcher("/addUser").forward(request, response);
				return;
			}
			if (request.getParameter("email") != null
					&& !request.getParameter("email").equals("")) {
				user.setEmail(request.getParameter("email"));
				
			}else{
				request.setAttribute("err", "email不可为空");
				request.getRequestDispatcher("/addUser").forward(request, response);
				return;
			}
			if (request.getParameter("grade") != null
					&& !request.getParameter("grade").equals("")) {
				user.setGrade(Integer.parseInt(request.getParameter("grade")));
			}else{
				request.setAttribute("err", "grade不可为空");
				request.getRequestDispatcher("/addUser").forward(request, response);
				return;
			}
			if (request.getParameter("password") != null
					&& !request.getParameter("password").equals("")) {
				user.setPassword(request.getParameter("password"));
			}else{
				request.setAttribute("err", "password不可为空");
				request.getRequestDispatcher("/addUser").forward(request, response);
				return;
			}
			request.setAttribute("scene", "添加");
			if(us.addUser(user)){
				request.getRequestDispatcher("/sucess").forward(request, response);
			}else{
				request.getRequestDispatcher("/failed").forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}

package com.jesse.web.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jesse.domain.User;
import com.jesse.service.UserService;
import com.jesse.service.impl.UserServiceImpl;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//完成验证码的校验：
		//获得session中保存的验证码的信息
		String code1 = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//接收校验前台表单提交的验证码的信息
		String code2 = request.getParameter("verifyCode");
		if(code2 == null || !code2.equalsIgnoreCase(code1)) {
			request.setAttribute("msg","验证码输入不正确！");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);			
			return;
		}
		//完成密码确认校验
		String password = request.getParameter("password");
		String pwd2  = request.getParameter("pwd2");
		if(!password.equals(pwd2)) {
			request.setAttribute("msg","两次输入密码不一致！");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);			
			return;			
		}
		//1、接收数据
		String username = request.getParameter("username");
		//2、封装数据
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);		
		//3、处理数据
		UserService userService = new UserServiceImpl();
		userService.add(user);
		User existUser = userService.login(user);
		//4、跳转页面
		request.getSession().setAttribute("existUser", existUser);
		response.sendRedirect(request.getContextPath() + "/MessageServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

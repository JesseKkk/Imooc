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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//完成验证码的校验：
		//获得session中保存的验证码的信息
		String code1 = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		//接收校验前台表单提交的验证码的信息
		String code2 = request.getParameter("verifyCode");
		if(code2 == null || !code2.equalsIgnoreCase(code1)) {
			request.setAttribute("msg","验证码输入不正确！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);			
			return;
		}
		//1、接收数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2、封装数据
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//3、处理数据
		UserService userService = new UserServiceImpl();
		User existUser = userService.login(user);
		//4、根据处理结果，完成页面跳转
		if(existUser == null) {
			//登录失败
			//返回到登录页面
			request.setAttribute("msg","用户名或密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			//登陆成功
			//将用户的信息进行保存，进行页面跳转
			request.getSession().setAttribute("existUser", existUser);
			response.sendRedirect(request.getContextPath() + "/MessageServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

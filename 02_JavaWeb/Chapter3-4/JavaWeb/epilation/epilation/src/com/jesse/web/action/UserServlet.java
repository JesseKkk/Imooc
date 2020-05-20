package com.jesse.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jesse.domain.User;
import com.jesse.service.UserService;
import com.jesse.service.Impl.UserServiceImpl;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据method分类处理
		String methodname = request.getParameter("method");
		if("login".equals(methodname)) {
			//登录
			login(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 用户模块：登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		//获得用户列表的集合：
		List<User> userList = (List<User>)getServletContext().getAttribute("userList");
		User existUser = userService.login(userList,user);
		//显示数据
		//根据existUser的返回值，校验用户身份信息
		if(existUser == null) {
			//登录失败
			request.setAttribute("msg", "用户名或密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			//登陆成功
			//将用户信息保存
			request.getSession().setAttribute("existUser", existUser);
			response.sendRedirect(request.getContextPath() + "/admin/categoryList.jsp");
		}
	}
}

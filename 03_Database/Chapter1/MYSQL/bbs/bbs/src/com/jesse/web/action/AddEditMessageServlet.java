package com.jesse.web.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jesse.domain.Message;
import com.jesse.domain.User;
import com.jesse.service.MessageService;
import com.jesse.service.impl.MessageServiceImpl;

@WebServlet("/AddEditMessageServlet")
public class AddEditMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String methodName = request.getParameter("method");
		//判断
		if(methodName.equals("add")) {
			add(request,response);
		}else if(methodName.equals("edit")) {
			edit(request,response);
		}else if(methodName.equals("update")) {
			update(request,response);
		}else if(methodName.equals("delete")) {
			delete(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 信息模块：删除
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1、接收参数
		int mid = Integer.parseInt(request.getParameter("mid"));	
		//2、处理数据
		MessageService messageService = new MessageServiceImpl();
		messageService.delete(mid);
		//4、跳转显示
		response.sendRedirect(request.getContextPath() + "/MyMessageServlet");		
	}
	
	/**
	 * 信息模块：修改
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1、接收参数
		int mid = Integer.parseInt(request.getParameter("mid"));	
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//2、封装数据
		Message message = new Message();
		message.setMid(mid);
		message.setTitle(title);
		message.setContent(content);
		//3、处理数据
		MessageService messageService = new MessageServiceImpl();
		messageService.update(message);
		//4、跳转显示
		response.sendRedirect(request.getContextPath() + "/MyMessageServlet");
	}
	
	/**
	 * 信息模块：编辑
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//1、接收数据
		int mid = Integer.parseInt(request.getParameter("mid"));
		//2、处理数据
		MessageService messageService = new MessageServiceImpl();
		Message message = messageService.find(mid);
		//3、跳转页面
		request.setAttribute("message", message);
		request.getRequestDispatcher("/admin/edit_message.jsp").forward(request, response);
		
	}

	/**
	 * 信息模块：增加
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1、接收参数
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date  date = new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createTime=df.format(date);
		User existUser = (User)request.getSession().getAttribute("existUser");
		//2、封装数据
		Message message = new Message();
		message.setTitle(title);
		message.setContent(content);
		message.setCreateTime(createTime);
		message.setUser(existUser);
		//3、处理数据
		MessageService messageService = new MessageServiceImpl();
		messageService.add(message);
		//4、跳转显示
		response.sendRedirect(request.getContextPath() + "/MyMessageServlet");
	}
}

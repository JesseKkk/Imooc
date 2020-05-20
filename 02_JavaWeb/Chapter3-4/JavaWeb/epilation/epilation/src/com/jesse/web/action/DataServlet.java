package com.jesse.web.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jesse.domain.Data;
import com.jesse.service.DataService;
import com.jesse.service.Impl.DataServiceImpl;
import com.jesse.utils.UploadUtils;


@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据method分类处理
		String methodname = request.getParameter("method");
		if("addData".equals(methodname)) {
			//添加数据
			addData(request,response);
		}else if("delete".equals(methodname)){
			delete(request,response);
		}else if("edit".equals(methodname)) {
			edit(request,response);
		}else if("update".equals(methodname)) {
			update(request,response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 数据模块：更新
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、接收数据
		Map<String,String> map = UploadUtils.uploadFile(request);
		//日期正则校验
		String dataId = map.get("dataId");
		String dataDate = map.get("dataDate");
		if(!Pattern.matches("\\d{8}", dataDate)) {
			request.setAttribute("msg", "请输入正确的日期！");
			request.setAttribute("dataId", dataId);			
			request.getRequestDispatcher("/admin/updateData.jsp").forward(request, response);								
			return;
		}			
		//2、封装数据
		Data data = new Data();
		data.setDataId(dataId);
		data.setDataName(map.get("dataName"));
		data.setCategoryName(map.get("categoryName"));
		data.setDataDate(dataDate);
		data.setDataPic(map.get("path"));
		data.setRemarks(map.get("remarks"));
		//3、处理数据
		DataService dataService = new DataServiceImpl();
		List<Data> dataList = (List<Data>)request.getServletContext().getAttribute("dataList");		
		dataService.update(dataList,data);
		request.getServletContext().setAttribute("dataList", dataList);
		//4、跳转显示
		response.sendRedirect(request.getContextPath() + "/admin/dataList.jsp");	
	}
	
	/**
	 * 数据模块：编辑
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、接收数据
		//2、封装数据
		String dataId = request.getParameter("dataId");
		//3、处理数据
		//让request携带bookId，使得updateBook.jsp中能默认显示bookId
		request.setAttribute("dataId", dataId);
		//4、显示数据
		request.getRequestDispatcher("/admin/updateData.jsp").forward(request, response);								
		return;		
	}
	
	/**
	 * 数据模块删除
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1、接收数据
		String dataId = request.getParameter("dataId");
		//2、封装数据
		//3、处理数据
		DataService dataService = new DataServiceImpl();
		List<Data> dataList = (List<Data>)request.getServletContext().getAttribute("dataList");
		dataService.delete(dataList, dataId);
		getServletContext().setAttribute("dataList", dataList);
		//4、显示数据
		response.sendRedirect(request.getContextPath() + "/admin/dataList.jsp");	
	}
	
	/**
	 * 数据模块：添加
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addData(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//1、接收数据
		Map<String,String> map = UploadUtils.uploadFile(request);
		// 数据编号正则校验
		String dataId = map.get("dataId");
		if(!Pattern.matches("hr\\d{4}", dataId)) {
			request.setAttribute("msg", "请按照如下格式输入数据编号：hrxxxx(x代表数字)");
			request.getRequestDispatcher("/admin/addData.jsp").forward(request, response);
			return;
		}		
		//日期正则校验
		String dataDate = map.get("dataDate");
		if(!Pattern.matches("\\d{8}", dataDate)) {
			request.setAttribute("msg", "请输入正确的日期！");
			request.getRequestDispatcher("/admin/addData.jsp").forward(request, response);								
			return;
		}			
		//2、封装数据
		Data data = new Data();
		data.setDataId(dataId);
		data.setDataName(map.get("dataName"));
		data.setCategoryName(map.get("categoryName"));
		data.setDataDate(dataDate);
		data.setDataPic(map.get("path"));
		data.setRemarks(map.get("remarks"));
		//3、处理数据
		DataService dataService = new DataServiceImpl();
		List<Data> dataList = (List<Data>)request.getServletContext().getAttribute("dataList");		
		//增加的同时判断编号是否存在，并且按照图书编号进行排序
		if(!dataService.add(dataList,data)) {
			request.setAttribute("msg", "当前数据编号已经存在");
			request.getRequestDispatcher("/admin/addData.jsp").forward(request, response);
			return;				
		}else {
			request.getServletContext().setAttribute("dataList", dataList);
		}
		//4、跳转显示
		response.sendRedirect(request.getContextPath() + "/admin/dataList.jsp");	
	}

}

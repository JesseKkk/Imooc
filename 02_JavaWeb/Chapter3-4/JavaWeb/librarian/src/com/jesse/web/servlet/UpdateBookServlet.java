package com.jesse.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jesse.domain.Book;
import com.jesse.service.BookService;
import com.jesse.service.imp.BookServiceImp;
import com.jesse.utils.UploadUtils;


@WebServlet("/updatebook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收数据
		//创建Map集合用于保存数据
		Map<String, String> map = new HashMap<String, String>();
		//文件上传的代码：
		//1.创建磁盘文件项工厂
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		//2. 创建核心解析类
		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		//3.解析请求对象，将对象分成几个部分(FileItem)
		try {
			List<FileItem> list = fileUpload.parseRequest(request);
			//保存bookId的值，方便价格输错时进行通过request回传bookId的值
			String bookIdValue = null;
			//4.遍历集合获得每个部分的对象
			for(FileItem fileItem : list) {
				//判断是普通项还是文件上传项
				if(fileItem.isFormField()) {
					//获得普通项的名称：
					String name = fileItem.getFieldName();
					//获得普通项的值：
					String value = fileItem.getString("UTF-8");
					//保存bookId的值，方便价格输错时进行通过request回传bookId的值
					if(name.equals("bookId")) {
						bookIdValue = value;
					}
					//价格正则校验
					if(name.equals("bookPrice")) {
						if(!Pattern.matches("\\d{1,4}", value)) {
							request.setAttribute("msg", "请输入正确的价格！");
							//注意通过URL回传bookId的值
							request.setAttribute("bookId",bookIdValue );						
							request.getRequestDispatcher("/updateBook.jsp").forward(request, response);								
							return;
						}						
					}
					map.put(name, value);
				}else {
					//文件上传项
					//获得文件的名称：
					String fileName = fileItem.getName();
					//获得唯一的文件名：
					String uuidFileName = UploadUtils.getUuidFileName(fileName);
					//获得文件的输入流：
					InputStream is = fileItem.getInputStream();
					//需要将文件写入到服务器的某个路径
					String path = getServletContext().getRealPath("/img");
					String url = path + "\\" +uuidFileName;
					map.put("path", request.getContextPath() + "/img/" + uuidFileName);
					//System.out.println(map.toString());
					OutputStream os = new FileOutputStream(url);
					int len = 0;
					byte[] b = new byte[1024];
					while((len = is.read(b)) != -1) {
						os.write(b,0,len);
					}
					is.close();
					os.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//封装数据
		Book book = new Book();
		book.setBookId(map.get("bookId"));
		book.setBookName(map.get("bookName"));
		book.setCategoryName(map.get("categoryName"));
		book.setBookPrice(map.get("bookPrice"));
		book.setBookPic(map.get("path"));
		book.setRemarks(map.get("remarks"));
		//处理数据
		BookService bookService = new BookServiceImp();
		List<Book> bookList = (List<Book>)request.getServletContext().getAttribute("bookList");
		bookService.update(bookList,book);
		request.getServletContext().setAttribute("bookList", bookList);
		//实现数据
		response.sendRedirect(request.getContextPath() + "/bookList.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

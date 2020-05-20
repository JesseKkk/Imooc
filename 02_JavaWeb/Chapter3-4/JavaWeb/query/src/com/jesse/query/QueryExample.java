
package com.jesse.query;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QueryExample
 */
@WebServlet("/example")
public class QueryExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
//		String value = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("Maths","数学");
		map.put("Chinese","语文");
		map.put("English","英语");
		map.put("Physics","物理");
		map.put("History","历史");
////		Set<String> a= map.keySet();
////		Iterator<String> it = a.iterator();
////		while(it.hasNext()) {
////			if(it.next().equals(name)) {
////				value = map.get(name);
////				break;
////			}
////		}
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		if(value!=null) {
//			out.println("<h1  style='color:blue'>" + value + "<h1>");
//		}else {
//			out.println("<h1 style='color:red;'>没有找到对应的单词解释<h1>");
//		}
		boolean flag =map.containsKey(name);
		if(flag) {
			request.setAttribute("name", map.get(name)); 
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute( "name","没有找到对应的单词解释");
			response.sendRedirect("/query/fail.jsp");
		}
	}

}

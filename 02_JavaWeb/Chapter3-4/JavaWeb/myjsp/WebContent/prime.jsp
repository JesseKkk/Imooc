<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.util.*,java.text.*"  %>
	<%!
		boolean isPrime(int num){
			boolean flag = true;
			for(int j = 2; j < num; j++){
				if(num % j == 0){
					flag = false;
					break;
				}
			}
			return flag;
		}
	%>
	<%
		List<Integer> primes = new ArrayList();
		for(int i = 2; i <=1000; i++){
			boolean flag = isPrime(i);
			if(flag == true){
				//out.println("<h1>" + i + "</h1>");
				primes.add(i);
			}
		}
	%>
	<%
		for(int p : primes){
			//out.println("<h1>" + p + "是质数<h1>");
	%>
			<h1 style="color:red;"><%=p %>是质数</h1>
	<%
		}
	%>
</body>
</html>
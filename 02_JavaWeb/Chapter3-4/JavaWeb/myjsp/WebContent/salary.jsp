<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>year</th>
			<th>salary</th>
		</tr>
		<%
			for(int i = 0; i <=50; i++){
				out.println("<tr>");
				out.println("<td>" + i + "</td>");
				int sal = 0;
				if(i <=5){
					sal =1500 + i * 150;
				}else if(i > 5 && i <= 10){
					sal = 1500 + 150 * 5 + 300 * (i - 5);
				}else if(i > 10){
					sal = 1500 + 150 * 5 + 300 * 5  + 375  * (i-10);
				}
				out.println("<td>" + sal + "</td>");
				out.println("</tr>");
			}
		
		%>
		<tr>
			<td>0</td>
			<td>1500</td>
		</tr>	
		<tr>
			<td>1</td>
			<td>1650</td>
		</tr>			
	</table>
</body>
</html>
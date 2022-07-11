<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>All Registrations</h2>
<table>
<tr> 
<th>Name</th>
<th>City</th>
<th>Email</th>
<th>Mobile</th>
<th>Delete</th>
<tr/>

<%
ResultSet res=(ResultSet)request.getAttribute("result");
while(res.next()){
	%>
	
	<tr> 
<td><%=res.getString(1) %></td>
<th><%=res.getString(2) %></th>
<th><%=res.getString(3) %></th>
<th><%=res.getString(4) %></th>
<th><a href="delete?email=<%=res.getString(3) %>">delete</th>
<tr/>
	


<%} %>
</table>



</body>
</html>
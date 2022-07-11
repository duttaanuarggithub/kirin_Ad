<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Registration</title>
</head>
<body>
<form action="new" method="post">


<pre>
Name<input type="text" placeholder="Enter your name here" name="name"/>
City<input type="text" placeholder="Enter your city here" name="city"/>
Email<input type="email" placeholder="Enter your emailid here" name="email"/>
Mobile<input type="number" placeholder="Enter your mobile no. here" name="mobile"/>

<input type="submit" value="save"/>

</pre>



</form>
<%
if (request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));

	
	
}

%>
</body>
</html>
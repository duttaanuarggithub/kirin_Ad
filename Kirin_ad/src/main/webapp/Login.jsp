<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login here....</title>
</head>
<body>
<h2>Login </h2>
<br>
<%
if (request.getAttribute("error")!=null){
	out.println(request.getAttribute("error"));

	
	
}

%>

</br>
<form action="login" method="post">

<pre>
Email<input type="email" placeholder="Enter your emailid here" name="email"/>

Password<input type="password" placeholder="Enter your password here" name="password"/>

<input type="submit" value="Login"/>

</pre>

</form>

</body>
</html>
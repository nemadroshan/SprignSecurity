<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2><%=request.getUserPrincipal().getName()%>
		is not autorisized for this page
	</h2>
	<a href="home.htm">home</a>
	<br>
	<a href="logout">Logout</a>
</body>
</html>
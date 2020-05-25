<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Faculty Page</h1><br>
<h2>Currenty User Name <%= request.getUserPrincipal().getName() %></h2>
<a href="../index.jsp">home</a>
<a href="admin.jsp">Go to Admin</a>
<br><br>
<a href="../logout">Logout</a>
</body>
</html>
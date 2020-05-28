<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<h1 style="color: red; text-align: center">Result Page</h1>

<br>
<b> ${wMsg} <%=request.getUserPrincipal().getName()%></b>
<br>
<br>
<a href="home.htm">home</a>
<br>
<a href="logout">Logout</a>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeira P�gina JSP</title>
</head>
<body>
<%
String app = request.getParameter("app");
out.print("Aqui � um conteudo "+app);
%>
</body>
</html>
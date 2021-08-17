<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeira Página JSP</title>
</head>
<body>
	<%
	String app = request.getParameter("app");
	if (app == null)
		app = "JSP";
	out.print("Aqui é um conteudo " + app);
	%>
	<br>
	<a href="formCadastro.jsp">Novo Cadastro</a>
	<br>
	<a href="listaPessoas.jsp">Lista de Pessoas</a>
</body>
</html>
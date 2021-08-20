<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primeira Página JSP</title>
</head>
<body>
<%@ include file="menu.jsp"%>
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
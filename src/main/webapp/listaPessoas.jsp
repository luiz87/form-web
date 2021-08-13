<%@page import="org.senai.model.Pessoa"%>
<%@page import="java.util.List"%>
<%@page import="org.senai.dao.PessoaDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="org.senai.db.Conexao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Pessoas</title>
</head>
<body>

	<%
	PessoaDao objDao = new PessoaDao();
	List<Pessoa> ls = objDao.listaPessoa();
	if (ls.size() > 0) {
	%>
	<table>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
		</tr>

		<%
		for (Pessoa p : ls) {
		%>
		<tr>
			<td><%=p.getNomeCompleto()%></td>
			<td><%=p.getEmail()%></td>
		</tr>
		<%
		}
		%>

	</table>
	<%
	}
	%>
</body>
</html>
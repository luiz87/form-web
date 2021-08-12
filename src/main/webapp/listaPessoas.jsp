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
	Connection cont = Conexao.conectar();

	if (cont != null) {
		PreparedStatement pst = cont.prepareStatement("select nome_completo, email from pessoas");
		ResultSet rs = pst.executeQuery();
	%>
	<table>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
		</tr>

		<%
		while (rs.next()) {
		%>
		<tr>
			<td>
				<%
				out.print(rs.getString("nome_completo"));
				%>
			</td>
			<td><%=rs.getString("email")%></td>
		</tr>
		<%
		}
		%>

	</table>
	<%
	cont.close();
	}
	%>
</body>
</html>
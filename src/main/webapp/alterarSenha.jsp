<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
	<%@ include file="menu.jsp"%>
	<%
	if(usuario == null){
		response.sendRedirect("formCadastro.jsp");
	}
	%>
	<form action="alterarSenha" method="post">
		<fieldset>
			<legend>ACESSAR</legend>
			<label for="senha">Senha Atual:</label> <input class="larguraTexto"
				type="password" name="senhaAtual" id="senhaAtual"
				placeholder="Digite sua senha"> <label for="senha">Nova Senha:</label> 
				<input class="larguraTexto" type="password" name="novaSenha"
				id=""novaSenha"" placeholder="Digite sua senha"> <label
				for="senha"> Confirmar Senha:</label> <input class="larguraTexto"
				type="password" name="confirmarSenha" id="confirmarSenha"
				placeholder="Digite sua senha"> <input type="submit"
				class="bt" value="Gravar">


			<%
			String erro = request.getParameter("erro");
			if (erro != null) {
			%>

			<script type="text/javascript">
				alert("Login ou senha não encontrado");
			</script>
			<%
			}
			%>
		</fieldset>
	</form>
</body>
</html>
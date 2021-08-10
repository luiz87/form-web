<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/estilo.css">

    <style>
        .bloco-inline label,
        .bloco-inline input,
        .bloco-inline * {
            display: inline;
        }
    </style>
</head>

<body>
    <form action="api-cadastro.jsp">
        <fieldset>
            <legend>CADASTRO</legend>
            <img id="img-java" src="img/java.png" alt="imagem java">
            <label for="nome">Nome Completo:</label>
            <input class="larguraTexto" type="text" id="nome" name="nome-completo"
                placeholder="Digite seu nome completo">
            <label for="telefone">Telefone:</label>
            <input class="larguraTexto" type="text" placeholder="(61)9.9999-9999">
            <label for="dtNascimento">Data de Nascimento:</label>
            <input class="larguraTexto" type="date" id="dtNascimento" name="dt-nascimento">
            <label for="email">E-mail:</label>
            <input class="larguraTexto" type="email" id="email">
            <label for="sexo">Sexo:</label>
            <div class="bloco-inline">
                <input type="radio" id="masc" name="sexo" value="m"> <label for="masc"> Masculino</label>
                <input type="radio" id="fem" name="sexo" value="f"> <label for="fem"> Feminino</label>
            </div>
            <label for="">Tecnologias:</label>
            <div class="bloco-inline">
                <input type="checkbox" id="html" name="tecnologia" value="html"> <label for="html"> HTML</label>
                <input type="checkbox" id="css" name="tecnologia" value="css"><label for="css"> CSS</label>
                <input type="checkbox" id="java" name="tecnologia" value="java"><label for="java"> Java</label>
                <input type="checkbox" id="php" name="tecnologia" value="php"><label for="php"> PHP</label>
            </div>
            <label for="">Escolaridade:</label>
            <select name="escolaridade" id="escolaridade">
                <option value="">Selecione</option>
                <option value="Fundamental">Fundamental</option>
                <option value="Ensino Médio">Ensino Médio</option>
                <option value="Superio">Superio</option>
            </select>
            <input type="submit" class="bt" value="Enviar">
            <input type="reset" class="bt" value="Limpar">
        </fieldset>
    </form>
</body>

</html>
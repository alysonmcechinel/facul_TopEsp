<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CadastroCliente.css" />
<title>Cadastro Cliente</title>
</head>
<body>
	<header>
		<span class="title">Cadastro de Clientes</span>
	</header>

	<form method="POST" action='ClienteController' name="AddCliente">
		<div class="div-form">
			<div>
				<span>ID</span>: <br /> 
				
				<input type="text" name="id" readonly="readonly" value="<c:out value="${cliente.id}" />"/> <br /> 
				
				<span>Nome</span>: <br /> 
				
				<input type="text" name="nome" required value="<c:out value="${cliente.nome}" />" /> <br /> 
				
				<span class="span">Email</span>: <br /> 
				
				<input type="text" name="email" required value="<c:out value="${cliente.email}" />" /> <br />
			</div>
			<div>
				<span>Cidade</span>: <br /> 
				
				<input type="text" name="cidade" required value="<c:out value="${cliente.cidade}" />" /> <br /> 
				
				<span class="span">Telefone</span>: <br /> 
				
				<input type="text" name="telefone" required value="<c:out value="${cliente.telefone}" />" /> <br />
			</div>
		</div>
		<div class="div-button">
			<button class="button" type="submit" value="Submit">Enviar</button>
			<a href="index.jsp">Voltar</a>
		</div>
	</form>
</body>
</html>
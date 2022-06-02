<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CadastroCelular.css" />
<meta charset="ISO-8859-1">
<title>Cadastro de Celular</title>
</head>
<body>
	<header><span class="title">Cadastro de Celular</span></header>

    <form method="POST" action='CelularController' name="AddCelular">
      <div class="div-form">
        <div>
        	<span>ID</span>: <br /> 
				
		  	<input type="text" name="celularid" readonly="readonly" value="<c:out value="${celular.id}" />"/> <br />
		  	        
         	<span>Nome</span>: <br />
          	
          	<input type="text" name="nome" required value="<c:out value="${celular.nome}" />" /> <br />
          
          	<span class="span">Marca</span>: <br />
          
          	<input type="text" name="marca" required value="<c:out value="${celular.marca}" />" /> <br />
        </div>
        <div>
          	<span>Cor</span>: <br />
          
          	<input type="text" name="cor" required value="<c:out value="${celular.cor}" />" /> <br />
          
          	<span class="span">Tela</span>: <br />
          
          	<input type="text" name="tela" required value="<c:out value="${celular.tela}" />" /> <br />
        </div>
        <div>
          	<span>Memoria RAM</span>: <br />
          
          	<input type="text" name="memoria" required value="<c:out value="${celular.memoria}" />" /> <br />
          
          	<span class="span">Preço</span>: <br />
          
          	<input type="text" name="preco" required value="<c:out value="${celular.preco}" />" /> <br />
        </div>
      </div>
      <div class="div-button">
        <button class="button" type="submit" value="Submit">Enviar</button>
        <a href="index.jsp">Voltar</a>
      </div>
    </form>
</body>
</html>
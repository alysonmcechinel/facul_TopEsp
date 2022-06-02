<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CadastroAcessorio.css"/>
<title>Cadastro Acessorio</title>
</head>
<body>
	<header><span class="title">Cadastro de Acessorio</span></header>

    <form method="POST" action='AcessorioController' name="AddAcessorio">
      <div class="div-form">
        <div>
        	
          <span>ID</span>: <br /> 
				
		  <input type="text" name="acessorioid" readonly="readonly" value="<c:out value="${acessorio.id}" />"/> <br />
        
          <span>Nome</span>: <br />
          
          <input type="text" name="nome" required value="<c:out value="${acessorio.nome}" />" /> <br />
          
          <span class="span">Marca</span>: <br />
          
          <input type="text" name="marca" required value="<c:out value="${acessorio.marca}" />" /> <br />
        </div>
        <div>
          <span>Cor</span>: <br />
          
          <input type="text" name="cor" required value="<c:out value="${acessorio.cor}" />" /> <br />
          
  		  <span class="span">Preço</span>: <br />
          
          <input type="text" name="preco" required value="<c:out value="${acessorio.preco}" />" /> <br />
        </div>
      <div class="div-button">
        <button class="button" type="submit" value="Submit">Enviar</button>
        <a href="index.jsp">Voltar</a>
      </div>
    </form>
</body>
</html>
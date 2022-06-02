<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="listar.css" />
<title>Insert title here</title>
</head>
<body>

	<table  border=1>
        <thead>
            <tr>
                <th>Celular Id</th>
                <th>Nome</th>
                <th>Marca</th>
                <th>Cor</th>
                <th>Preco</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${acessorios}" var="acessorio">
                <tr>
                    <td><c:out value="${acessorio.id}" /></td>
                    <td><c:out value="${acessorio.nome}" /></td>
                    <td><c:out value="${acessorio.marca}" /></td>
                    <td><c:out value="${acessorio.cor}" /></td>
                    <td><c:out value="${acessorio.preco}" /></td>
                    <td><a href="AcessorioController?action=edit&acessorioid=<c:out value="${acessorio.id}"/>">Editar</a></td>
                    <td><a href="AcessorioController?action=delete&acessorioid=<c:out value="${acessorio.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <p><a href="AcessorioController?action=insert">Adicionar Celular</a></p>
    <p><a href="index.jsp">Voltar</a></p>
</body>
</html>
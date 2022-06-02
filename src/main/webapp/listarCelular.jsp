<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="listar.css" />
<title>Lista de Celular</title>
</head>
<body>
	<table  border=1>
        <thead>
            <tr>
                <th>Celular Id</th>
                <th>Nome</th>
                <th>Marca</th>
                <th>Cor</th>
                <th>Tela</th>
                <th>Memoria</th>
                <th>Preco</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${celular}" var="celular">
                <tr>
                    <td><c:out value="${celular.id}" /></td>
                    <td><c:out value="${celular.nome}" /></td>
                    <td><c:out value="${celular.marca}" /></td>
                    <td><c:out value="${celular.cor}" /></td>
                    <td><c:out value="${celular.tela}" /></td>
                    <td><c:out value="${celular.memoria}" /></td>
                    <td><c:out value="${celular.preco}" /></td>
                    <td><a href="CelularController?action=edit&celularid=<c:out value="${celular.id}"/>">Editar</a></td>
                    <td><a href="CelularController?action=delete&celularid=<c:out value="${celular.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <p><a href="CelularController?action=insert">Adicionar Celular</a></p>
    <p><a href="index.jsp">Voltar</a></p>
</body>
</html>
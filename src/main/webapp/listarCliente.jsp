<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="listar.css" />
<title>Lista de Cliente</title>
</head>
<body>
	<table border=1>
        <thead>
            <tr>
                <th>Cliente Id</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Cidade</th>
                <th>Telefone</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.id}" /></td>
                    <td><c:out value="${cliente.nome}" /></td>
                    <td><c:out value="${cliente.email}" /></td>
                    <td><c:out value="${cliente.cidade}" /></td>
                    <td><c:out value="${cliente.telefone}" /></td>
                    <td><a href="ClienteController?action=edit&clienteid=<c:out value="${cliente.id}"/>">Editar</a></td>
                    <td><a href="ClienteController?action=delete&clienteid=<c:out value="${cliente.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <p><a href="ClienteController?action=insert">Adicionar Cliente</a></p>
    <p><a href="index.jsp">Voltar</a></p>
</body>
</html>
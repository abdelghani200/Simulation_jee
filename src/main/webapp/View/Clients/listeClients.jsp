<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 17/10/2023
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste Clients</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/liste.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<c:import url="/View/Templetes/header.jsp" />
<div class="container container_liste">
    <h1 style="margin-bottom: 10px;">Liste des Clients</h1>
    <a href="/View/Clients/addClients.jsp" class="add-client-button search-button" style="text-decoration: none">
        <i class="fas fa-plus"></i> Ajouter client
    </a>
    <form method="GET" action="${pageContext.request.contextPath}/Clients" class="search-form">
        <input type="text" name="action" value="search" hidden>
        <input type="text" name="query" class="search-input" placeholder="Rechercher des clients">
        <button type="submit" class="search-button">Rechercher</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>Code du Client</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Date de Naissance</th>
            <th>Téléphone</th>
            <th>Adresse</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${clients}" var="client">
            <tr>
                <td>${client.code}</td>
                <td>${client.nom}</td>
                <td>${client.prenom}</td>
                <td>${client.dateNaissance}</td>
                <td>${client.telephone}</td>
                <td>${client.adresse}</td>
                <td>
                    <c:url value='${pageContext.request.contextPath}/Clients?action=edit&code=${client.code}' var="editClientURL" />
                    <a href="${editClientURL}" class="icon-link green">
                        <i class="fas fa-edit"></i>
                    </a>

                    <c:url value='${pageContext.request.contextPath}/Clients?action=delete&code=${client.code}' var="deleteClientURL" />
                    <a href="${deleteClientURL}" class="icon-link red">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<c:import url="/View/Templetes/footer.jsp" />
</body>
</html>


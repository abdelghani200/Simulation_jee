<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 18/10/2023
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste Employes</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/liste.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<c:import url="/View/Templetes/header.jsp" />
<div class="container">
    <h1 style="margin-bottom: 10px;">Liste des Employes</h1>
    <a href="/View/Employes/addEmploye.jsp" class="add-client-button search-button" style="text-decoration: none">
        <i class="fas fa-plus"></i> Ajouter employe
    </a>
    <form method="GET" action="${pageContext.request.contextPath}/Employes" class="search-form">
        <input type="text" name="action" value="search" hidden>
        <input type="text" name="query" class="search-input" placeholder="Rechercher des employes">
        <button type="submit" class="search-button">Rechercher</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>Matricule</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Date de Naissance</th>
            <th>Date de Recrutement</th>
            <th>Téléphone</th>
            <th>Adresse Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employes}" var="employe">
            <tr>
                <td>${employe.matricule}</td>
                <td>${employe.nom}</td>
                <td>${employe.prenom}</td>
                <td>${employe.dateNaissance}</td>
                <td>${employe.dateRecrutement}</td>
                <td>${employe.telephone}</td>
                <td>${employe.adresseEmail}</td>
                <td>
                    <c:url value='${pageContext.request.contextPath}/Employes?action=edit&matricule=${employe.matricule}' var="editEmployeURL" />
                    <a href="${editEmployeURL}" class="icon-link green">
                        <i class="fas fa-edit"></i>
                    </a>

                    <c:url value='${pageContext.request.contextPath}/Employes?action=delete&matricule=${employe.matricule}' var="deleteEmployeURL" />
                    <a href="${deleteEmployeURL}" class="icon-link red">
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


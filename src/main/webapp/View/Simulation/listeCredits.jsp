<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 20/10/2023
  Time: 12:09
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
    <h1>Liste des Credits</h1>
    <form method="GET" action="${pageContext.request.contextPath}/Employes" class="search-form">
        <input type="text" name="action" value="search" hidden>
        <input type="text" name="query" class="search-input" placeholder="Rechercher des employes">
        <button type="submit" class="search-button">Rechercher</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>numero</th>
            <th>montant</th>
            <th>remarques</th>
            <th>duree</th>
            <th>etat</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${credits}" var="credit">
            <tr>
                <td>${credit.numero}</td>
                <td>${credit.montant}</td>
                <td>${credit.remarques}</td>
                <td>${credit.duree}</td>
                <td>${credit.etat}</td>
                <td>
                    <c:url value='${pageContext.request.contextPath}/Credits?action=edit&numero=${credit.numero}' var="editEmployeURL" />
                    <a href="${editEmployeURL}" class="icon-link green">
                        <i class="fas fa-edit"></i>
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

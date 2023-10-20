<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 17/10/2023
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/header.css">
</head>
<body>
<header>
    <div id="logo">
        <h1>EasyBank</h1>
    </div>
    <nav>
        <ul>
            <li><a href="/View/Templetes/acceuil.jsp">Home</a></li>
            <li><a href="/Clients">Clients</a></li>
            <li><a href="/Employes">Employes</a></li>
            <li><a href="/View/Simulation/credit.jsp">Simulation</a></li>
        </ul>
    </nav>
</header>


</body>
</html>

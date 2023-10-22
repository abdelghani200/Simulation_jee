<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="title" value="${requestScope.title}" />
    <title>EasyBank - ${title}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/list.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/credit.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/js/index.js">
</head>
<body style="display: block;">
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


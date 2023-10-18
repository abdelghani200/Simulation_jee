<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Client</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/add.css">
</head>
<body>
<c:import url="/View/Templetes/header.jsp" />
<c:if test="${not empty requestScope.error}">
    <div class="error-message">
        Error: ${requestScope.error}
    </div>
</c:if>
<div class="container">
    <h1>Ajouter un Client</h1>
    <form action="${request.contextPath}/Clients?action=add" method="post">
        <input type="hidden" name="action" value="add">
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" required><br>
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br>
        <label for="prenom">Prenom:</label>
        <input type="text" id="prenom" name="prenom" required><br>
        <label for="datenaissance">Date de Naissance (YYYY-MM-DD):</label>
        <input type="date" id="datenaissance" name="datenaissance" required><br>
        <label for="telephone">Tel:</label>
        <input type="text" id="telephone" name="telephone" required><br>
        <label for="adresse">Adresse:</label>
        <input type="text" id="adresse" name="adresse" required><br>
        <input type="submit" value="Add Client">
    </form>
</div>
</body>
</html>

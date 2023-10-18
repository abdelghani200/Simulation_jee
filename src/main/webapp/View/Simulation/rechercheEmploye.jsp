<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 17/10/2023
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/credit.css">
</head>
<body>
<form id="search-form" action="/Employes" method="get">
    <label for="searchValue">Rechercher un employé :</label>
    <input type="text" id="searchValue" name="searchValue">
    <br>
    <input type="submit" value="Rechercher">
</form>

<div id="search-results">
    <!-- Display search results here -->
</div>

</body>
<script>
    document.getElementById("search-form").addEventListener("submit", function (event) {
        event.preventDefault();
        chercheClients();
    });

    function chercheClients() {
        var searchValue = document.getElementById("searchValue").value;
        var url = '${pageContext.request.contextPath}/Employes?action=search&searchValue=' + searchValue;

        var xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');

        xhr.onload = function () {
            if (xhr.status === 200) {
                // Update the search results on the same page.
                document.getElementById('search-results').innerHTML = xhr.responseText;
            } else {
                console.log('AJAX request failed');
            }
        };

        xhr.send();
    }
</script>

</html>

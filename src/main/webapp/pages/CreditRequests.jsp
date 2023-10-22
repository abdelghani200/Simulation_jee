<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../components/header.jsp" />
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
        <c:forEach var="credit" items="${creditRequests}" >
            <tr>
                <td>${credit.id}</td>
                <td>${credit.borrowedAmount}</td>
                <td>${credit.remark}</td>
                <td>${credit.duration}</td>
                <td>${credit.status}</td>
                <td>
                    <c:url value='${pageContext.request.contextPath}/Credits?action=edit&numero=${credit.id}' var="editEmployeURL" />
                    <a href="${editEmployeURL}" class="icon-link green">
                        <i class="fas fa-edit"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<c:import url="../components/footer.jsp" />

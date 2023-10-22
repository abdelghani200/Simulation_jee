<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 16/10/2023
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/credit.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/js/index.js">
</head>
<body>
<div id="credit-section" class="left-column">
<form id="credit-form" action="">
    <label for="project">Mon projet</label>
    <select class="form-select" id="project" name="project">
        <option value="1">J'ai besion d'argent</option>
        <option value="2">Je finance mon véhicule d'occasion</option>
        <option value="3">Je Gère mes imprévus</option>
        <option value="3">Je finance mon véhicule neuf</option>
        <option value="3">J'équipe ma maison'</option>
    </select>

    <label for="role">Je suis</label>
    <select class="form-select" id="role" name="role">
        <option value="1">Salarie du secteur privé</option>
        <option value="2">Fonctionnaire</option>
        <option value="3">Commercant</option>
        <option value="3">Artisan</option>
        <option value="3">Retraité</option>
        <option value="3">Autres professions</option>
    </select>

    <label for="amount">Montant (en DH)</label>
    <input type="number" id="amount" value="100">
    <input type="range" id="amount-range" name="amount" min="1" required>

    <label for="duration">Durée (en mois)</label>
    <input type="number" id="duration" value="12"/>
    <input type="range" id="duration-range" name="duration" min="1" value="12" required>

    <label for="monthly-payment-range">Mensualités (en DH)</label>
    <input type="number" id="monthly-payment" value="300">
    <input type="range" id="monthly-payment-range" name="monthly-payment" min="1" required>


    <input type="submit" value="Simuler" id="simulate-button">
</form>
</div>

<div class="right-column">
    <!-- Contenu de la colonne de droite -->
    <h2 class="hhhh">Mon récapitulatif :</h2>
    <p>Projet sélectionné : <span id="selected-project">-</span></p>
    <p>Statut sélectionné : <span id="selected-role">-</span></p>
    <p>Montant sélectionné (en DH) : <span id="selected-amount">-</span></p>
    <p>Durée sélectionnée (en mois) : <span id="selected-duration">-</span></p>
    <p>Mensualités sélectionnées (en DH) : <span id="selected-monthly-payment">-</span></p>
</div>

<div id="search-section" class="right-column form_12" style="display: none;">
    <label for="selectedEmployee">Sélectionnez un employé :</label>
    <select id="selectedEmployee" name="selectedEmployee">
        <c:forEach items="${employes}" var="employe">
            <option value="${employe.matricule}">
                    ${employe.nom} ${employe.prenom}
            </option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" value="Continue" id="continue-employee-button">

</div>

<div id="client-selection" class="right-column form_12" style="display: none;">
    <label for="selectedClient">Sélectionnez un client :</label>
    <select id="selectedClient" name="selectedClient">
        <option value="client1">Client 1</option>
        <option value="client2">Client 2</option>
        <option value="client3">Client 3</option>
        <!-- Ajoutez ici les clients que vous souhaitez proposer -->
    </select>
    <br>
    <input type="submit" value="Sélectionner le client" id="select-client-button">
</div>



</body>



<script>
    // Gestion de la modification du range
    const rangeInput = document.getElementById('monthly-payment-range');
    const numberInput = document.getElementById('monthly-payment');

    rangeInput.addEventListener('input', () => {
        numberInput.value = rangeInput.value;
    });

    const InputamountRange = document.getElementById('amount-range');
    const numberInputAmount = document.getElementById('amount');

    InputamountRange.addEventListener('input', () => {
        numberInputAmount.value = InputamountRange.value;
    });

    const rangeInputDuration = document.getElementById('duration-range');
    const numberInputDuration = document.getElementById('duration');

    rangeInputDuration.addEventListener('input', () => {
        numberInputDuration.value = rangeInputDuration.value;
    });

    const simulateButton = document.getElementById('simulate-button');

    simulateButton.addEventListener('click', function (event) {
        event.preventDefault();

        const selectedProject = document.getElementById('project').value;
        const selectedRole = document.getElementById('role').value;
        const selectedAmount = document.getElementById('amount').value;
        const selectedDuration = document.getElementById('duration').value;
        const selectedMonthlyPayment = document.getElementById('monthly-payment').value;

        localStorage.setItem('selectedProject', selectedProject);
        localStorage.setItem('selectedRole', selectedRole);
        localStorage.setItem('selectedAmount', selectedAmount);
        localStorage.setItem('selectedDuration', selectedDuration);
        localStorage.setItem('selectedMonthlyPayment', selectedMonthlyPayment);


        document.getElementById('selected-project').textContent = selectedProject;
        document.getElementById('selected-role').textContent = selectedRole;
        document.getElementById('selected-amount').textContent = selectedAmount;
        document.getElementById('selected-duration').textContent = selectedDuration;
        document.getElementById('selected-monthly-payment').textContent = selectedMonthlyPayment;

        document.getElementById('credit-section').style.display = 'none';
        document.getElementById('search-section').style.display = 'block';
    });


    const continueEmployeeButton = document.getElementById('continue-employee-button');
    const searchSection = document.getElementById('search-section');
    const clientSelection = document.getElementById('client-selection');

    continueEmployeeButton.addEventListener('click', function (event) {
        event.preventDefault();

        searchSection.style.display = 'none';
        clientSelection.style.display = 'block';
    });


</script>

</html>

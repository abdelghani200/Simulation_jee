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
<div class="left-column">
<form id="credit-form" action="rechercheEmploye.jsp">
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


    <input type="submit" value="Simuler">
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
</body>

<script>

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

</script>

</html>

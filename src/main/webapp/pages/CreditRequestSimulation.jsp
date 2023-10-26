<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../components/header.jsp" />

<div class="flex">
<div class="min-h-screen bg-gray-100 py-6 flex flex-col justify-center sm:py-12 flex-auto" id="credit-section_1">
    <div class="relative py-3 w-9/12 sm:max-w-xl sm:mx-auto">
        <div class="relative px-4 py-10 bg-white mx-8 md:mx-0 shadow rounded-3xl sm:p-10">
            <div class="max-w-md mx-auto">
                <div class="flex items-center space-x-5">
                    <div class="h-14 w-14 bg-yellow-200 rounded-full flex flex-shrink-0 justify-center items-center text-yellow-500 text-2xl font-mono">C</div>
                    <div class="block pl-2 font-semibold text-xl self-start text-gray-700">
                        <h2 class="leading-relaxed">Create Credit</h2>
                    </div>
                </div>

                <div class="divide-y divide-gray-200">
                    <div class="py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7">
                        <div class="container">
                            <div id="credit-section">
                                <form id="credit-form">
                                    <div class="flex flex-col">
                                        <label for="project" class="leading-loose">Mon projet</label>
                                        <select class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" id="project" name="project">
                                            <option value="1">J'ai besoin d'argent</option>
                                            <option value="2">Je finance mon vehicule d'occasion</option>
                                            <option value="3">Je gere mes imprevus</option>
                                            <option value="4">Je finance mon vehicule neuf</option>
                                            <option value="5">J'équipe ma maison</option>
                                        </select>
                                    </div>

                                    <div class="flex flex-col">
                                        <label for="role" class="leading-loose">Je suis</label>
                                        <select class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" id="role" name="role">
                                            <option value="1" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600">Salarie du secteur prive</option>
                                            <option value="2" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600">Fonctionnaire</option>
                                            <option value="3" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600">Commerçant</option>
                                            <option value="4" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600">Artisan</option>
                                            <option value="5" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600">Retraite</option>
                                            <option value="6" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600">Autres professions</option>
                                        </select>
                                    </div>

                                    <div class="flex flex-col">
                                        <label for="amount" class="leading-loose">Montant (en DH)</label>
                                        <input type="number" id="amount" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" placeholder="Montant en DH">
                                        <input type="range" id="amount-range" name="amount" min="1" required class="w-64 mt-2">
                                    </div>

                                    <div class="flex flex-col">
                                        <label for="duration" class="leading-loose">Duree (en mois)</label>
                                        <input type="number" id="duration" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" placeholder="Duree en mois">
                                        <input type="range" id="duration-range" name="duration1" min="1" value="12" required class="w-64 mt-2">
                                    </div>

                                    <div class="flex flex-col">
                                        <label for="monthly-payment" class="leading-loose">Mensualites (en DH)</label>
                                        <input type="number" id="monthly-payment" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" placeholder="Mensualites en DH">
                                        <input type="range" id="monthly-payment-range" name="monthly-payment" min="1" required class="w-64 mt-2">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="pt-4 flex items-center space-x-4">
                    <button class="bg-blue-500 flex justify-center items-center w-full text-white px-4 py-3 rounded-md focus:outline-none" id="simulate-button">Create</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="min-h-screen bg-gray-100 py-6 flex flex-col justify-center sm:py-12 flex-auto">
    <div class="relative py-3 w-8/12 sm:max-w-xl sm:mx-auto">
        <div class="relative px-4 py-10 bg-white mx-8 md:mx-0 shadow rounded-3xl sm:p-10">
            <div class="max-w-md mx-auto">
                <div class="flex items-center space-x-5">
                    <div class="h-14 w-14 bg-yellow-200 rounded-full flex flex-shrink-0 justify-center items-center text-yellow-500 text-2xl font-mono">R</div>
                    <div class="block pl-2 font-semibold text-xl self-start text-gray-700">
                        <h2 class="leading-relaxed">Mon recapitulatif :</h2>
                    </div>
                </div>
                <form class="divide-y divide-gray-200" action="${pageContext.request.contextPath}/creditRequests" method="post">
                    <div class="py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7">
                        <div class="flex flex-col">
                            <label class="leading-loose">Montant (en DH)</label>
                            <input type="number" name="borrowedamount" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" readonly>
                        </div>
                        <div class="flex flex-col">
                            <label class="leading-loose">Duree (en mois)</label>
                            <input type="number" name="duration" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" readonly>
                        </div>
                        <div class="flex flex-col">
                            <label class="leading-loose">Mensualites (en DH)</label>
                            <input type="number" name="monthlyamount" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" readonly>
                        </div>
                        <div class="flex flex-col" style="display: none" id="recap-section1">
                            <label class="leading-loose">Client</label>
                            <input type="text" name="client_id" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" readonly>
                        </div>
                        <div class="flex flex-col" style="display: none" id="recap-section2">
                            <label class="leading-loose">Employe</label>
                            <input type="text" name="employe_id" class="px-4 py-2 border focus:ring-gray-500 focus:border-gray-900 w-full sm:text-sm border-gray-300 rounded-md focus:outline-none text-gray-600" readonly>
                        </div>
                        <div class="pt-4 flex items-center space-x-4" id="button_create">
                            <button class="flex justify-center items-center w-1/2 text-gray-900 px-4 py-3 rounded-md focus:outline-none">
                                <svg class="w-6 h-6 mr-3" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12"></path></svg> Cancel
                            </button>
                            <button class="bg-blue-500 flex justify-center items-center w-1/2 text-white px-4 py-3 rounded-md focus:outline-none" id="selectedClientEmploye">Create</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        </div>
    </div>
</div>


<div id="search-section" class="min-h-screen bg-gray-100 py-6 flex flex-col justify-center sm:py-12 flex-auto">
    <div class="relative py-3 w-8/12 sm:max-w-xl sm:mx-auto">
        <div class="relative px-4 py-10 bg-white mx-8 md:mx-0 shadow rounded-3xl sm:p-10">
            <div class="max-w-md mx-auto">
                <div class="flex items-center space-x-5">
                    <div class="h-14 w-14 bg-yellow-200 rounded-full flex flex-shrink-0 justify-center items-center text-yellow-500 text-2xl font-mono">C</div>
                    <div class="block pl-2 font-semibold text-xl self-start text-gray-700">
                        <h2 class="leading-relaxed">Search Section</h2>
                    </div>
                </div>
                <div class="divide-y divide-gray-200">
                    <div class="py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7">
                        <div class="flex flex-col">
                            <label for="selectedEmployee" class="leading-loose">Selectionnez un employe :</label>
                            <select id="selectedEmployee" name="selectedEmployee" class="px-4 py-2 border focus:ring-gray-500 focus-border-gray-900 w-full sm-text-sm border-gray-300 rounded-md focus-outline-none text-gray-600">
                            </select>
                        </div>
                        <div class="flex flex-col">
                            <label for="selectedClient" class="leading-loose">Selectionnez un client :</label>
                            <select id="selectedClient" name="selectedClient" class="px-4 py-2 border focus:ring-gray-500 focus-border-gray-900 w-full sm-text-sm border-gray-300 rounded-md focus-outline-none text-gray-600">

                            </select>
                        </div>
                        <input type="submit" value="Continue" id="continue-employee-button" class="bg-blue-500 text-white px-4 py-3 rounded-md focus-outline-none">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


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

        const selectedAmount = document.getElementById('amount').value;
        const selectedDuration = document.getElementById('duration').value;
        const selectedMonthlyPayment = document.getElementById('monthly-payment').value;
        const selectedClientName = document.getElementById('selectedClient').value;
        const selectedEmployeeName = document.getElementById('selectedEmployee').value;

        localStorage.setItem('selectedAmount', selectedAmount);
        localStorage.setItem('selectedDuration', selectedDuration);
        localStorage.setItem('selectedMonthlyPayment', selectedMonthlyPayment);
        localStorage.setItem('selectedClientName', selectedClientName);
        localStorage.setItem('selectedEmployeeName', selectedEmployeeName);

        document.querySelector("input[name='borrowedamount']").value = selectedAmount || '-';
        document.querySelector("input[name='monthlyamount']").value = selectedMonthlyPayment || '-';
        document.querySelector("input[name='duration']").value = selectedDuration || '-';



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

    const selectedClientEmployeButton = document.getElementById('continue-employee-button');
    selectedClientEmployeButton.addEventListener('click', function (event) {
        event.preventDefault();

        const selectedClient = document.getElementById('selectedClient').textContent;
        const selectedEmployee = document.getElementById('selectedEmployee').textContent;

        localStorage.setItem('selectedClientName', selectedClient);
        localStorage.setItem('selectedEmployeeName', selectedEmployee);

        document.getElementById('someElement').textContent = selectedClient;
        document.getElementById('anotherElement').textContent = selectedEmployee;


    });


    document.addEventListener("DOMContentLoaded", function() {
        const simulateButton = document.getElementById('simulate-button');
        const creditSection = document.getElementById('credit-section_1');
        const searchSection = document.getElementById('search-section');

        searchSection.style.display = 'none';


        simulateButton.addEventListener('click', function(event) {
            event.preventDefault();

            creditSection.replaceWith(searchSection);
            searchSection.style.display = 'block';
        });
    });

        document.addEventListener("DOMContentLoaded", function() {

        const recapSection = document.getElementById('recap-section1');
        const recapSection1 = document.getElementById('recap-section2');
        const recapSection2 = document.getElementById('button_create');
        recapSection.style.display = 'none'
        recapSection1.style.display = 'none'
        recapSection2.style.display = 'none'

        continueEmployeeButton.addEventListener('click', function(event) {
        event.preventDefault();

        recapSection.style.display = 'block';
        recapSection1.style.display = 'block';
        recapSection2.style.display = 'block';

    });
    });


        getEmployees();
        getClients();




</script>

<c:import url="../components/footer.jsp" />

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

const rangeInput = document.getElementById('monthly-payment-range');
const numberInput = document.getElementById('monthly-payment');

rangeInput.addEventListener('input', () => {

    numberInput.value = rangeInput.value;
});

const BASEPATH = "http://localhost:8080/EasyBankEE/api/";

function getClients() {
    fetch(BASEPATH + "clients")
        .then(response => response.json())
        .then(data => {
            const selectedClientDropdown = document.getElementById('selectedClient');
            selectedClientDropdown.innerHTML = "";

            data.forEach(client => {
                const option = document.createElement('option');
                option.value = client.id;
                option.textContent = client.first_name;
                selectedClientDropdown.appendChild(option);
            });
        })
        .catch(error => console.error("Error: ", error));
}

function findClient(id) {
    fetch(BASEPATH + "clients/" + id)
        .then(response => response.json())
        .then(data => {
            console.log(data); // Utilisez 'console.log' pour afficher les données
        })
        .catch(error => console.error("Error: ", error));
}

function getEmployees() {
    fetch(BASEPATH + "employees")
        .then(response => response.json())
        .then(data => {
            const selectedEmployeeDropdown = document.getElementById('selectedEmployee');
            selectedEmployeeDropdown.innerHTML = "";

            data.forEach(employee => {
                const option = document.createElement('option');
                option.value = employee.id;
                option.textContent = employee.first_name +"Agnece" + employee.agnecy.name;
                selectedEmployeeDropdown.appendChild(option);
            });
        })
        .catch(error => console.error("Error: ", error));
}


function findEmployee(id) {
    fetch(BASEPATH + "employees/" + id)
        .then(response => response.json())
        .then(data => {
            console.log(data); // Utilisez 'console.log' pour afficher les données
        })
        .catch(error => console.error("Error: ", error));
}

const BASEPATH = "http://localhost/EasyBank/"

function getClients() {
    let clients = {};
    fetch(BASEPATH + "clients")
        .then(response => response.json())
        .then(data => {
            clients = data;
            console(clients);
        })
        .catch(error => console.error("Error: ", error));
}


function findClient(id) {
    let client;
    fetch(BASEPATH + "clients/"+ id)
        .then(response => response.json())
        .then(data => {
            client = data;
            console(client);
        })
        .catch(error => console.error("Error: ", error));
}

function getEmployees() {
    let employees = {};
    fetch(BASEPATH + "employees")
        .then(response => response.json())
        .then(data => {
            employees = data;
            console(employees);
        })
        .catch(error => console.error("Error: ", error));
}

function findEmployee(id) {
    let employee;
    fetch(BASEPATH + "employees/"+ id)
        .then(response => response.json())
        .then(data => {
            employee = data;
            console(employee);
        })
        .catch(error => console.error("Error: ", error));
}
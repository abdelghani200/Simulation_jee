

CREATE TABLE eazybank.agences
(
    code SERIAL PRIMARY KEY,
    name varchar(255),
    address varchar(255),
    phone varchar(12),
);

CREATE TABLE employes
(
    matricule SERIAL PRIMARY KEY ,
    nom varchar(255) ,
    prenom varchar(255),
    daterecrutement date,
    datenaissance date,
    adresseemail varchar(255),
    telephone varchar(255),
    agency_code integer,
    FOREIGN KEY (agency_code) REFERENCES eazybank.agences(code)
);



CREATE TABLE eazybank.clients (
     code SERIAL PRIMARY KEY,
     nom VARCHAR(255),
     prenom VARCHAR(255),
     dateNaissance DATE,
     telephone VARCHAR(255),
     address VARCHAR(255),
     employeeMatricule INT,
     FOREIGN KEY (employeeMatricule) REFERENCES eazybank.employes(matricule)
);


CREATE TABLE credit (
     number SERIAL PRIMARY KEY,
     credit_date DATE DEFAULT CURRENT_DATE,
     amount DOUBLE PRECISION,
     remarques VARCHAR(255),
     duration INT,
     state VARCHAR(255) DEFAULT 'Active',
     client_code INT,
     FOREIGN KEY (client_code) REFERENCES eazybank.clients(code)
);
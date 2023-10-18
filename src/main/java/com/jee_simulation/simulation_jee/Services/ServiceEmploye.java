package com.jee_simulation.simulation_jee.Services;


import com.jee_simulation.simulation_jee.Dao.ImEmploye;
import com.jee_simulation.simulation_jee.Dto.Employe;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ServiceEmploye {

    private final ImEmploye employeService;

    public ServiceEmploye(ImEmploye imEmploye) throws SQLException {
        this.employeService = new ImEmploye();
    }


    public Optional<Employe> saveEmploye(Employe employe){
        return employeService.save(employe);
    }

    public Optional<List<Employe>> getAllEmployes(){
        return employeService.readAllEmployes();
    }

    public Optional<Employe> getEmployeByMatricule(String matricule) {
        return employeService.findByMatricule(matricule);
    }

    public boolean updateEmploye(Employe employe) {
        return employeService.update(employe);
    }

    public Optional<Employe> findEmployeByEmailOrNomOrPrenom(String searchValue) {
        return employeService.findByEmailOrNomOrPrenom(searchValue);
    }

    public boolean deleteEmploye(String matricule) {
        return employeService.deleteEmploye(matricule);
    }



}


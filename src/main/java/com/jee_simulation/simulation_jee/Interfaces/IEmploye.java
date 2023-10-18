package com.jee_simulation.simulation_jee.Interfaces;

import com.jee_simulation.simulation_jee.Dto.Employe;

import java.util.List;
import java.util.Optional;

public interface IEmploye {


    Optional<Employe> findByMatricule(String matricule);
    Optional<List<Employe>> readAllEmployes();

    boolean deleteEmploye(String matricule);

    Optional<Employe> findById(int id);

    boolean update(Employe employe);

    Optional<Employe> findByEmailOrNomOrPrenom(String searchValue);

    Optional<Employe> changeAgence(Employe employe, String code_agence);

}

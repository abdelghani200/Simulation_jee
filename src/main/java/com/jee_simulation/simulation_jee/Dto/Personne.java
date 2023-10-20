package com.jee_simulation.simulation_jee.Dto;

import java.time.LocalDate;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {

    protected String nom;
    protected String prenom;
    protected String telephone;
    protected LocalDate dateNaissance;

    public Personne(String nom, String prenom, LocalDate datenaissance, String telephone) {
        setNom(nom);
        setPrenom(prenom);
        setTelephone(telephone);
        setDateNaissance(datenaissance);
    }
}

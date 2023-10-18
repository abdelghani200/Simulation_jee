package com.jee_simulation.simulation_jee.Dto;

import java.time.LocalDate;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "personne", schema = "gestion_bancaire")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected int id;
    @Column(name = "nom")
    protected String nom;
    @Column(name = "prenom")
    protected String prenom;
    @Column(name = "telephone")
    protected String telephone;

    @Column(name = "dateNaissance")
    private LocalDate dateNaissance;

    public Personne(String nom, String prenom, LocalDate datenaissance, String telephone) {
        setNom(nom);
        setPrenom(prenom);
        setTelephone(telephone);
        setDateNaissance(datenaissance);
    }
}

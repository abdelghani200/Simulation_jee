package com.jee_simulation.simulation_jee.Dto;

import java.time.LocalDate;


import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "agence")
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
    protected LocalDate dateNaissance;

}

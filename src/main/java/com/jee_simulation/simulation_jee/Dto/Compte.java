package com.jee_simulation.simulation_jee.Dto;

import com.jee_simulation.simulation_jee.Enums.TypeCompte;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "compte")

public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected int id;

    @Column(name = "numero")
    protected String numero;
    @Column(name = "solde")
    protected double solde;
    @Column(name = "dateCreation")
    protected LocalDate dateCreation;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    protected TypeCompte status;

    @ManyToOne
    protected Client client;
    @ManyToOne
    protected Employe employe;


}

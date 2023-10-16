package com.jee_simulation.simulation_jee.Dto;

import com.jee_simulation.simulation_jee.Enums.EtatCredit;

import java.time.LocalDate;

public class Credit {

    private Integer numero;
    private Double montant;
    private String remarques;
    private EtatCredit etat;
    private LocalDate date;
    private Integer duree;
    private Simulation simulation;

}

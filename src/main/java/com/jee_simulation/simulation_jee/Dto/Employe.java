package com.jee_simulation.simulation_jee.Dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employe extends Personne{

    private String matricule;
    private LocalDate dateRecrutement;
    private String adresseEmail;
    private List<Compte> compteArrayList = new ArrayList<>();
    private List<Client> clientArrayList = new ArrayList<>();

    private Agence agence;

}

package com.jee_simulation.simulation_jee.Dto;

import java.util.ArrayList;
import java.util.List;

public class Agence {

    private String code;
    private String nom;
    private String adresse;
    private String telephone;
    private List<Compte> comptes = new ArrayList<>();
    private List<Employe> employes = new ArrayList<>();


}

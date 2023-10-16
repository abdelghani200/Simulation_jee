package com.jee_simulation.simulation_jee.Dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employe")
public class Employe extends Personne{

    @Column(name = "matricule")
    private String matricule;
    @Column(name = "dateRecrutement")
    private LocalDate dateRecrutement;
    @Column(name = "adresseEmail")
    private String adresseEmail;

    @OneToMany(mappedBy = "employe")
    private List<Compte> compteArrayList = new ArrayList<>();
    @OneToMany(mappedBy = "client")
    private List<Client> clientArrayList = new ArrayList<>();


}

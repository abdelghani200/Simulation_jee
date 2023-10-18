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
@Table(name = "employe", schema = "gestion_bancaire")
public class Employe extends Personne{

    @Column(name = "matricule")
    private String matricule;
    @Column(name = "dateRecrutement")
    private LocalDate dateRecrutement;
    @Column(name = "adresseEmail")
    private String adresseEmail;

    @ManyToOne(fetch = FetchType.LAZY) // Or FetchType.EAGER depending on your needs
    @JoinColumn(name = "personne_id") // The name of the foreign key column in Employe table
    private Personne personne;


    public Employe(String nom, String prenom, LocalDate datenaissance, String telephone, String matricule, String adressemail, LocalDate daterecrutement) {
        super(nom, prenom, datenaissance, telephone);
        setMatricule(matricule);
        setAdresseEmail(adressemail);
        setDateRecrutement(daterecrutement);
    }
}

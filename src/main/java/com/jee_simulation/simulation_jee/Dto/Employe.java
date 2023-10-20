package com.jee_simulation.simulation_jee.Dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employes", schema = "eazybank")
public class Employe extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "daterecrutement")
    private LocalDate dateRecrutement;
    @Column(name = "adresseemail")
    private String adresseEmail;







    public Employe(String nom, String prenom, LocalDate datenaissance, String telephone, String matricule, String adressemail, LocalDate daterecrutement) {
        super(nom, prenom, datenaissance, telephone);
        setMatricule(matricule);
        setAdresseEmail(adressemail);
        setDateRecrutement(daterecrutement);
    }


}

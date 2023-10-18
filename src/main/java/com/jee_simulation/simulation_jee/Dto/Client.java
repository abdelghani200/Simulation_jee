package com.jee_simulation.simulation_jee.Dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "client", schema = "gestion_bancaire")
public class Client extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "adresse")
    private String adresse;



    public Client(String code, String adresse) {
        setCode(code);
        setAdresse(adresse);
    }

    public Client(String code, String nom, String prenom, LocalDate datenaissance, String telephone, String adresse) {
        super(nom, prenom, datenaissance, telephone);
        setCode(code);
        setAdresse(adresse);
    }
}

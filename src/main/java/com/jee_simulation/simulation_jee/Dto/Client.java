package com.jee_simulation.simulation_jee.Dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "clients", schema = "eazybank")
public class Client extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Integer code;

    @Column(name = "address")
    private String adresse;

    @ManyToOne
    @JoinColumn(name = "employeeMatricule")
    private Employe employe;





    public Client(Integer code, String adresse) {
        setCode(code);
        setAdresse(adresse);
    }

    public Client(Integer code, String nom, String prenom, LocalDate datenaissance, String telephone, String adresse) {
        super(nom, prenom, datenaissance, telephone);
        setCode(code);
        setAdresse(adresse);
    }
}

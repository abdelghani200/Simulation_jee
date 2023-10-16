package com.jee_simulation.simulation_jee.Dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "client")

public class Client extends Personne{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "code")
    private String code;
    @Column(name = "adresse")
    private String adresse;


}

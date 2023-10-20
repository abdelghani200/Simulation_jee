package com.jee_simulation.simulation_jee.Dto;

import jakarta.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "agence", schema = "eazybank")
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String nom;
    @Column(name = "address")
    private String adresse;
    @Column(name = "phone")
    private String telephone;







}

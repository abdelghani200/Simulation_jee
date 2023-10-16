package com.jee_simulation.simulation_jee.Dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "comptecourant")
public class CompteEpargne {

    @Id
    @GeneratedValue
    private Long id;

    private double tauxInteret;


}

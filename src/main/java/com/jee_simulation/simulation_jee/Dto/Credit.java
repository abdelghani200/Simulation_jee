package com.jee_simulation.simulation_jee.Dto;

import com.jee_simulation.simulation_jee.Enums.EtatCredit;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "montant")
    private Double montant;
    @Column(name = "remarques")
    private String remarques;
    @Column(name = "etat")
    @Enumerated(EnumType.STRING)
    private EtatCredit etat;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "duree")
    private Integer duree;


}

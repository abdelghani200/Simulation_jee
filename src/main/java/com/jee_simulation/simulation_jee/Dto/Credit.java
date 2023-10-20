package com.jee_simulation.simulation_jee.Dto;

import com.jee_simulation.simulation_jee.Enums.EtatCredit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "credit", schema = "eazybank")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "number")
    private Integer numero;
    @Column(name = "amount")
    private Double montant;
    @Column(name = "remarques")
    private String remarques;
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private EtatCredit etat;
    @Column(name = "credit_date")
    private LocalDate date;
    @Column(name = "duration")
    private Integer duree;


}

package com.jee_simulation.simulation_jee.Dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Simulation {

    private Double capitalEmprunte;
    private Integer paiementMensuelNum;
    private Double resultatSimulatin;
    private Double paiementMensuel;
    private Employe employe;
    private Client client;

}

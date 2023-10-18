package com.jee_simulation.simulation_jee.Services;

import com.jee_simulation.simulation_jee.Dao.ImEmploye;
import com.jee_simulation.simulation_jee.Dto.Simulation;

public class ServiceSimulation {

    private ImEmploye imEmployeService;

    public ServiceSimulation(ImEmploye imEmployeService){
        this.imEmployeService = imEmployeService;
    }

    public double createSimulation(Simulation simulation) {
        double resultat = 0;

        try {
            if (simulation.getCapitalEmprunte().toString().isEmpty() || simulation.getPaiementMensuelNum().toString().isEmpty()){
                System.out.println("Les champs montly_payment et borrowed_capital ne peuvent pas être vides.");
            } else {
                resultat = (simulation.getPaiementMensuel() * (1.2 / 12)) / (1 - Math.pow(1 + 1.2 / 12, -simulation.getPaiementMensuelNum()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return resultat;
    }

}

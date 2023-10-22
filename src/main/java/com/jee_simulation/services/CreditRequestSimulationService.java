package com.jee_simulation.services;

import com.jee_simulation.dto.CreditRequestSimulation;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreditRequestSimulationService {
    
    public Boolean isValid(CreditRequestSimulation simulation) {

        boolean isValid = 
            simulation.getMounthlyAmount() == 
                ( simulation.getBorrowedAmount() *  CreditRequestSimulation.yearlyProportionalRate / 12  ) 
            /
                ( 1 -  ( 1 + Math.pow(  ( CreditRequestSimulation.yearlyProportionalRate / 12 ), simulation.getDuration() ) ) );
        if(isValid)
            return true;
        return false;

    }
}

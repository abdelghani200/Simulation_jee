package com.jee_simulation.services;

import com.jee_simulation.dto.CreditRequestSimulation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@ApplicationScoped
@Default
public class CreditRequestSimulationService {
    
    public Boolean isValid(CreditRequestSimulation simulation) {
        
        if(simulation == null)
            return false;
        boolean isValid = 
            simulation.getMonthlyAmount() == 
                ( simulation.getBorrowedAmount() *  CreditRequestSimulation.yearlyProportionalRate / 12  ) 
            /
                ( 1 -  ( 1 + Math.pow(  ( CreditRequestSimulation.yearlyProportionalRate / 12 ), simulation.getDuration() ) ) );
        return isValid;

    }
}

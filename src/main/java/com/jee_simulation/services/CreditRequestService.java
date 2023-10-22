package com.jee_simulation.services;

import com.jee_simulation.dao.interfaces.CreditRequestDao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class CreditRequestService {
    
    @Inject
    private CreditRequestSimulationService simulationValidator;
    
    @Inject
    @Named("credit_request_dao_hibernate_implementation")
    private CreditRequestDao creditRequestDao;


    
}

package com.jee_simulation.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jee_simulation.dto.CreditRequestSimulation;

import jakarta.inject.Inject;

public class CreditRequestSimulationServiceTest {
    
    private CreditRequestSimulation correctSimulation;
    private CreditRequestSimulation incorrectSimulation;
    
    @Inject
    private CreditRequestSimulationService creditRequestSimulationService;

    @BeforeAll
    public void init(){

        correctSimulation = CreditRequestSimulation.builder()
                                    .duration(12)
                                    .borrowedAmount(10000)
                                    .mounthlyAmount(834.87)
                                    .build();
        incorrectSimulation = CreditRequestSimulation.builder()
                                    .duration(12)
                                    .borrowedAmount(42_000_000.50)
                                    .mounthlyAmount(320012.22)
                                    .build();
                                    
    }

    @Test
    public void isValidMethodShouldReturnTrue() {

        boolean result = creditRequestSimulationService.isValid(correctSimulation);
        assertTrue(result);

    }

    @Test
    public void isValidMethodShouldReturnFalse() {

        boolean result = creditRequestSimulationService.isValid(incorrectSimulation);
        assertFalse(result);

    }
}

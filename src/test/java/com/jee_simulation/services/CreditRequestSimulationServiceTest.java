package com.jee_simulation.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jee_simulation.dto.CreditRequestSimulation;

public class CreditRequestSimulationServiceTest {
    
    private static CreditRequestSimulation correctSimulation;
    private static CreditRequestSimulation incorrectSimulation;
    private static CreditRequestSimulation incompletteSimulation;
    
    private CreditRequestSimulationService creditRequestSimulationService;

    public CreditRequestSimulationServiceTest() {
        creditRequestSimulationService = new CreditRequestSimulationService();
    }

    @BeforeAll
    public static void init(){

        correctSimulation = CreditRequestSimulation.builder()
                                    .duration(1)
                                    .borrowedAmount(0D)
                                    .monthlyAmount(0D)
                                    .build();
        incorrectSimulation = CreditRequestSimulation.builder()
                                    .duration(12)
                                    .borrowedAmount(42_000_000.50)
                                    .monthlyAmount(320012.22)
                                    .build();
        incompletteSimulation = CreditRequestSimulation.builder()
                                    .duration(1)
                                    .monthlyAmount(0D)
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

    @Test
    public void isValidMethodShouldReturnFalseWhenSimulationIsNull() {
        
        boolean result = creditRequestSimulationService.isValid(null);
        assertFalse(result); 

    }

    @Test
    public void isValidMethodShouldThrowNullPointerException() {

        assertThrows(NullPointerException.class, () -> creditRequestSimulationService.isValid(incompletteSimulation));

    }
    
}

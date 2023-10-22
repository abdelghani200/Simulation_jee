package com.jee_simulation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreditRequestSimulation {
    
    public static final double yearlyProportionalRate = 0.12;
    private int duration;
    private double borrowedAmount;
    private double mounthlyAmount;

}

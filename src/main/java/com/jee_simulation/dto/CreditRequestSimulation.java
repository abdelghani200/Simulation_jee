package com.jee_simulation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreditRequestSimulation {
    
    public static final double yearlyProportionalRate = 0.12;
    private Integer duration;
    private Double borrowedAmount;
    private Double monthlyAmount;

}

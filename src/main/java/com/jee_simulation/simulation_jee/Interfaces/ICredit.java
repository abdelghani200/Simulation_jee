package com.jee_simulation.simulation_jee.Interfaces;

import com.jee_simulation.simulation_jee.Dto.Credit;
import com.jee_simulation.simulation_jee.Enums.EtatCredit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ICredit {

    Optional<Credit> create(Credit credit);
    List<Credit> read();

    boolean update(int numero, EtatCredit etat);

    List<Credit> getByEtat(EtatCredit etat);

    List<Credit> getByDate(LocalDate date);

}

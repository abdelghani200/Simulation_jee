package com.jee_simulation.simulation_jee.Interfaces;

import com.jee_simulation.simulation_jee.Dto.Personne;

import java.util.Optional;

public interface IPersonne<T extends Personne> {

    Optional<T> save(T personne);

}

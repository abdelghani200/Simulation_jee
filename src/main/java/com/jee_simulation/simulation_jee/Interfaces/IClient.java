package com.jee_simulation.simulation_jee.Interfaces;

import com.jee_simulation.simulation_jee.Dto.Client;

import java.util.List;
import java.util.Optional;

public interface IClient {

    Optional<Client> findByCode(String code);
    List<Client> readAll();

    boolean deleteClient(String code);

    boolean update(Client client);
    Optional<Client> findByEmailOrNomOrPrenom(String searchValue);

    Optional<Client> findById(int id);

}

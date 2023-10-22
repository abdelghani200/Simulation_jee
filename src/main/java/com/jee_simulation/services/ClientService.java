package com.jee_simulation.services;

import com.jee_simulation.dao.interfaces.ClientDao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class ClientService {
    
    @Inject
    @Named("client_dao_hibernate_implementation")
    private ClientDao clientDaoImpl;

}

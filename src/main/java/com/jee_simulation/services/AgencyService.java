package com.jee_simulation.services;

import java.util.List;

import com.jee_simulation.dao.interfaces.AgencyDao;
import com.jee_simulation.entities.Agency;
import com.jee_simulation.entities.Client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class AgencyService {
    
    @Inject
    @Named("agency_dao_hibernate_implementation")
    private AgencyDao agencyDao;

    public List<Agency> getAll() {
        return agencyDao.read();
    }

    public Agency find(int agencyId) {
        return agencyDao.find(agencyId).orElse(null);   
    }

}

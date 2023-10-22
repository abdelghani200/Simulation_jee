package com.jee_simulation.dao;

import java.util.List;
import java.util.Optional;

import com.jee_simulation.dao.interfaces.AgencyDao;
import com.jee_simulation.entities.Agency;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@ApplicationScoped
@Priority(1)
public class AgencyDaoImpl implements AgencyDao {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Agency> read() {

        return entityManager.createQuery("FROM Agency", Agency.class)
                            .getResultList();

    }

    @Override
    public Optional<Agency> find(Integer identifier) {

        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Agency foundedAgency = entityManager.find(Agency.class, identifier);
            transaction.commit();
            return Optional.of(foundedAgency);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }
    
}

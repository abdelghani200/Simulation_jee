package com.jee_simulation.dao;

import java.util.List;
import java.util.Optional;

import com.jee_simulation.dao.interfaces.ClientDao;
import com.jee_simulation.dao.interfaces.EmployeeDao;
import com.jee_simulation.entities.Client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@ApplicationScoped
@Named("client_dao_hibernate_implementation")
public class ClientDaoImpl implements ClientDao {

    @Inject
    private final EntityManager entityManager;

    @Inject
    @Named("employee_dao_hibernate_implementation")
    private final EmployeeDao employeeDao;

    @Override
    public List<Client> read() {

        return entityManager.createQuery("FROM Client", Client.class)
                            .getResultList();
    
    }

    @Override
    public Optional<Client> find(Integer identifier) {
        
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Client foundedClient = entityManager.find(Client.class, identifier);
            transaction.commit();
            return Optional.of(foundedClient);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }
    
}

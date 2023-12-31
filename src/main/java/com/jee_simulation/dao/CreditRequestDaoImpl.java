package com.jee_simulation.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.jee_simulation.dao.interfaces.AgencyDao;
import com.jee_simulation.dao.interfaces.ClientDao;
import com.jee_simulation.dao.interfaces.CreditRequestDao;
import com.jee_simulation.entities.CreditRequest;
import com.jee_simulation.enums.CreditReuquestStatus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@ApplicationScoped
@Named("credit_request_dao_hibernate_implementation")
public class CreditRequestDaoImpl implements CreditRequestDao {

    @Inject
    private final EntityManager entityManager;

    @Inject
    @Named("client_dao_hibernate_implementation")
    private final ClientDao clientDao;

    @Inject
    @Named("agency_dao_hibernate_implementation")
    private final AgencyDao agencyDao;

    @Override
    public Optional<CreditRequest> create(CreditRequest creditRequest) {

        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(creditRequest);
            transaction.commit();
            return Optional.of(creditRequest);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public List<CreditRequest> read() {

        return entityManager.createQuery("FROM CreditRequest", CreditRequest.class)
                            .getResultList();

    }

    @Override
    public Optional<CreditRequest> find(Integer identifier) {

        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            var foundedCreditRequest = entityManager.find(CreditRequest.class, identifier);
            transaction.commit();
            return Optional.of(foundedCreditRequest);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public Optional<CreditRequest> updateStatus(CreditRequest creditRequest) {
        
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            var foundedCreditRequest = entityManager.find(CreditRequest.class, creditRequest.getId());
            foundedCreditRequest.setStatus(creditRequest.getStatus());
            transaction.commit();
            return Optional.of(foundedCreditRequest);
        } catch(Exception e) { e.printStackTrace(); }
        return Optional.empty();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CreditRequest> getByDate(LocalDate creditRequestDate) {
        
        String hql = "FROM CreditRequest WHERE requestDate = :date";
        return (List<CreditRequest>) entityManager.createQuery(hql) 
                                                  .setParameter("date", creditRequestDate)
                                                  .getResultList();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CreditRequest> getByStatus(CreditReuquestStatus creditRequestStatus) {
       
        String hql = "FROM CreditRequest WHERE status = :status";
        return (List<CreditRequest>) entityManager.createQuery(hql) 
                                                  .setParameter("status", creditRequestStatus)
                                                  .getResultList();

    }
     
}

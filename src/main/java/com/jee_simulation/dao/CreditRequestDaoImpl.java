package com.jee_simulation.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.jee_simulation.dao.interfaces.CreditRequestDao;
import com.jee_simulation.entities.CreditRequest;
import com.jee_simulation.enums.CreditRequestStatus;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@ApplicationScoped
@Priority(1)
public class CreditRequestDaoImpl implements CreditRequestDao {

    @Inject
    private EntityManager entityManager;

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
    public List<CreditRequest> getByStatus(CreditRequestStatus creditRequestStatus) {
       
        String hql = "FROM CreditRequest WHERE status = :status";
        return (List<CreditRequest>) entityManager.createQuery(hql) 
                                                  .setParameter("status", creditRequestStatus)
                                                  .getResultList();

    }
     
}

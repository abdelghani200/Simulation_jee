package com.jee_simulation.services;

import java.time.LocalDate;
import java.util.List;

import com.jee_simulation.dao.interfaces.CreditRequestDao;
import com.jee_simulation.entities.CreditRequest;
import com.jee_simulation.enums.CreditRequestStatus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreditRequestService {
        
    @Inject
    private CreditRequestDao creditRequestDao;

    public CreditRequest create(CreditRequest newCreditRequest) {
        return creditRequestDao.create(newCreditRequest).orElse(null);
    }

    public List<CreditRequest> read() {
        return creditRequestDao.read();
    }

    public CreditRequest find(int creditRequestId) {
        return creditRequestDao.find(creditRequestId).orElse(null);
    }

    public CreditRequest updateStatus(int creditRequestId, String newStatus) {

        var creditRequest = find(creditRequestId);
        var status =  CreditRequestStatus.valueOf(newStatus);
        creditRequest.setStatus(status);
        return creditRequestDao.updateStatus(creditRequest).orElse(null);

    }

    public List<CreditRequest> getByDate(LocalDate date) {
        return creditRequestDao.getByDate(date);
    }

    public List<CreditRequest> getByStatus(CreditRequestStatus status) {
        return creditRequestDao.getByStatus(status);
    }
    
}

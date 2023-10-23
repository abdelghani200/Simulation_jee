package com.jee_simulation.dao.interfaces;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.jee_simulation.entities.CreditRequest;
import com.jee_simulation.enums.CreditRequestStatus;

public interface CreditRequestDao extends Dao<CreditRequest, Integer> {

    Optional<CreditRequest> create(CreditRequest creditRequest);
    Optional<CreditRequest> updateStatus(CreditRequest creditRequest);
    List<CreditRequest> getByDate(LocalDate creditRequestDate);
    List<CreditRequest> getByStatus(CreditRequestStatus creditRequestStatus);
    
}

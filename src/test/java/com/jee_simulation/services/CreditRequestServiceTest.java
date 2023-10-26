package com.jee_simulation.services;

import com.jee_simulation.dao.CreditRequestDaoImpl;
import com.jee_simulation.entities.CreditRequest;
import com.jee_simulation.enums.CreditReuquestStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class CreditRequestServiceTest {

    @InjectMocks
    private CreditRequestService creditRequestService;

    @Mock
    private CreditRequestDaoImpl creditRequestDao;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreate() {
        CreditRequest newCreditRequest = new CreditRequest();
        when(creditRequestDao.create(newCreditRequest)).thenReturn(Optional.of(newCreditRequest));

        CreditRequest creditRequest = creditRequestService.create(newCreditRequest);

        assertNotNull(creditRequest);
    }

    @Test
    public void testRead() {
        List<CreditRequest> mockCreditRequests = List.of(new CreditRequest());
        when(creditRequestDao.read()).thenReturn(mockCreditRequests);

        List<CreditRequest> creditRequests = creditRequestService.read();

        assertEquals(1,creditRequests.size());
    }


    @Test
    public void testFind(){
        int creditRequestId = 1;

        CreditRequest creditRequest = new CreditRequest();
        when(creditRequestDao.find(creditRequestId)).thenReturn(Optional.of(creditRequest));

        CreditRequest foundRequest = creditRequestService.find(creditRequestId);
        assertNotNull(foundRequest);
    }

    @Test
    public void testUpdateStatus(){
        CreditRequest creditRequest = new CreditRequest();
        when(creditRequestDao.updateStatus(creditRequest)).thenReturn(Optional.of(creditRequest));

        CreditRequest updatedRequest = creditRequestService.updateStatus(creditRequest);

        assertNotNull(updatedRequest);
    }

    @Test
    public void testgetByDate(){
        LocalDate date = LocalDate.of(2023,10,23);
        List<CreditRequest> mockCreditRequests = List.of(new CreditRequest(), new CreditRequest());
        when(creditRequestDao.getByDate(date)).thenReturn(mockCreditRequests);

        List<CreditRequest> request = creditRequestService.getByDate(date);

        assertEquals(mockCreditRequests.size(), request.size());
    }

    @Test
    public void testgetByStatus(){
        CreditReuquestStatus status = CreditReuquestStatus.Pending;
        List<CreditRequest> mockCreditRequests = List.of(new CreditRequest(), new CreditRequest());

        when(creditRequestDao.getByStatus(status)).thenReturn(mockCreditRequests);

        List<CreditRequest> result = creditRequestService.getByStatus(status);

        assertEquals(mockCreditRequests.size(), result.size());
    }

}

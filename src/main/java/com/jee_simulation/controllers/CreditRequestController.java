package com.jee_simulation.controllers;

import java.io.IOException;
import java.time.LocalDate;

import com.jee_simulation.entities.CreditRequest;
import com.jee_simulation.enums.CreditRequestStatus;
import com.jee_simulation.services.CreditRequestService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/creditRequests")
public class CreditRequestController extends HttpServlet {
    
    @Inject
    private CreditRequestService creditRequestService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setAttribute("title", "Credit requests list");
        if( request.getParameter("id") != null )
            find(request, response);
        else if( request.getParameter("date") != null )
            getByDate(request, response);
        else if( request.getParameter("status") != null )
            getByStatus(request, response);
        else
            request.setAttribute("creditRequests", creditRequestService.read());
        request.getRequestDispatcher( "pages/CreditRequests.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        var creditRequest = CreditRequest.builder()
                            .borrowedAmount( Double.parseDouble( request.getParameter("borrowed_amount") ) )
                            .duration( Integer.parseInt( request.getParameter("duration") ))
                            .monthlyAmount( Double.parseDouble( request.getParameter("mounthly_amount") ) )
                            .build();

        request.setAttribute("newCreditRequest", creditRequestService.create(creditRequest));
        request.setAttribute("title", "New credit request");
        request.getRequestDispatcher("pages/creditRequest/CreditRequested.jsp").forward(request, response);

    }

    public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Integer id = Integer.parseInt( request.getParameter("id") );
        if( id != null  )
            request.setAttribute("foundedCreditRequest", creditRequestService.find(id));

    }

    public void getByDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LocalDate date = LocalDate.parse( request.getParameter("date") );
        if(date != null)
            request.setAttribute("creditRequestsByDate", creditRequestService.getByDate(date) );

    } 
    
    public void getByStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreditRequestStatus status = CreditRequestStatus.valueOf( request.getParameter("status") );
        if(status != null) 
            request.setAttribute("creditRequestByStatus", creditRequestService.getByStatus(status) );
            
    }
}

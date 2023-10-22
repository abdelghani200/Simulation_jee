package com.jee_simulation.controllers;

import java.io.IOException;

import com.jee_simulation.entities.CreditRequest;
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
        String id = request.getParameter("id");
        if( id == null || id.isEmpty() )
            request.setAttribute("creditRequests", creditRequestService.read());
        else
            request.setAttribute("foundedCreditRequest", creditRequestService.find( Integer.parseInt(id) ));
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
    
}

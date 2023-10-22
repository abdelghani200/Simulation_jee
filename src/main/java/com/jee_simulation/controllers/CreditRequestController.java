package com.jee_simulation.controllers;

import com.jee_simulation.services.CreditRequestService;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/credit_requests")
public class CreditRequestController extends HttpServlet {
    
    @Inject
    private CreditRequestService creditRequestService;

    
}

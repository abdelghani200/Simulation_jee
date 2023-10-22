package com.jee_simulation.controllers;

import java.io.IOException;

import com.jee_simulation.dto.CreditRequestSimulation;
import com.jee_simulation.services.CreditRequestSimulationService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/creditRequestSimulation")
public class CreditRequestSimulationController extends HttpServlet {
    
    @Inject
    private CreditRequestSimulationService creditRequestSimulationService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("title", "Credit request simulation");
        request.getRequestDispatcher("pages/CreditRequestSimulation.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var simulation = CreditRequestSimulation.builder()
                        .borrowedAmount( Double.parseDouble( request.getParameter("borrowed_amount") ) )
                        .duration( Integer.parseInt( request.getParameter("duration") ))
                        .monthlyAmount( Double.parseDouble( request.getParameter("mounthly_amount") ) )
                        .build();
        if( creditRequestSimulationService.isValid(simulation) )
            request.setAttribute("simulation", simulation);
        else 
            request.setAttribute("error", "Invalid credit request simulation");
        request.getRequestDispatcher("pages/CreditRequestSimulation.jsp").forward(request, response);
        
    }
    
}

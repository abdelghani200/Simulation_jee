package com.jee_simulation.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.jee_simulation.entities.Agency;
import com.jee_simulation.entities.CreditRequest;
import com.jee_simulation.enums.CreditReuquestStatus;
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

        List<CreditRequest> creditRequests = creditRequestService.read();

        request.setAttribute("creditRequests", creditRequests);

        request.getRequestDispatcher("pages/CreditRequests.jsp").forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            var creditRequest = CreditRequest.builder()
                    .borrowedAmount(Double.parseDouble(request.getParameter("borrowedamount")))
                    .duration(Integer.parseInt(request.getParameter("duration")))
                    .monthlyAmount(Double.parseDouble(request.getParameter("monthlyamount")))
                    .build();

            Optional<CreditRequest> createdCreditRequest = Optional.ofNullable(creditRequestService.create(creditRequest));

            if (createdCreditRequest.isPresent()) {
                request.setAttribute("newCreditRequest", createdCreditRequest.get());
            } else {
                // Gérez l'erreur ici si nécessaire
            }

            request.setAttribute("title", "New credit request");
            request.getRequestDispatcher("pages/CreditRequests.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Gérez les erreurs ici
        }
    }


}

package com.jee_simulation.simulation_jee.Servlets;

import com.jee_simulation.simulation_jee.Dao.ImCredit;
import com.jee_simulation.simulation_jee.Dto.Credit;
import com.jee_simulation.simulation_jee.Services.ServiceCredit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/Credits")
public class ServletCredit extends HttpServlet {

    private ServiceCredit serviceCredit;

    @Override
    public void init(){
        this.serviceCredit = new ServiceCredit(new ImCredit());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCredits(request, response);
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {

            default:

        }
    }


    private void listCredits(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Credit> credits = serviceCredit.getAll();

        request.setAttribute("credits", credits);
        //response.getWriter().println(credits);
        request.getRequestDispatcher("/View/Simulation/listeCredits.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }





}

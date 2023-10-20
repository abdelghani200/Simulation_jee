package com.jee_simulation.simulation_jee.Servlets;

import com.jee_simulation.simulation_jee.Dao.ImClient;
import com.jee_simulation.simulation_jee.Dto.Client;
import com.jee_simulation.simulation_jee.Services.ServiceClient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/Clients")
public class ServletClient extends HttpServlet {

    private ServiceClient serviceClient;
    public void init() {
        this.serviceClient = new ServiceClient(new ImClient());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listClients(request, response);
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "edit":
                editClient(request,response);
                break;
            case "update":
                updateClient(request,response);
                break;
            case "add":
                addClient(request,response);
                break;
            case "delete":
                deleteClient(request,response);
                break;
            case "search":
                chercheClients(request,response);
                break;
            default:
               // listClients(request, response);
        }
    }


    private void listClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = serviceClient.getAllClients();

        request.setAttribute("clients", clients);
        //response.getWriter().println(clients);
        request.getRequestDispatcher("/View/Clients/listeClients.jsp").forward(request, response);
    }


    private void chercheClients(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String query = request.getParameter("query");

        Optional<Client> searchResult = serviceClient.findClientByEmailOrNomOrPrenom(query);

        if (searchResult.isPresent()) {
            List<Client> clients = new ArrayList<>();
            clients.add(searchResult.get());
            request.setAttribute("clients", clients);
        } else {
            System.out.println("Aucun résultat trouvé.");
        }

        request.getRequestDispatcher("/View/Clients/listeClients.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }



    private void createOrUpdateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = Integer.parseInt(request.getParameter("code"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        LocalDate datenaissance = LocalDate.parse(request.getParameter("datenaissance"));
        String telephone = request.getParameter("telephone");
        String adresse = request.getParameter("adresse");

        Client client = new Client(code, nom, prenom, datenaissance, telephone, adresse);

        String action = request.getParameter("action");

        if ("update".equals(action)) {
            if (serviceClient.updateClient(client)){
                response.sendRedirect(request.getContextPath() + "/Clients?action=list");
            }
        } else if (serviceClient.saveClient(client).isPresent()) {
            response.sendRedirect(request.getContextPath() + "/Clients?action=list");
        } else {
            response.sendRedirect("/Clients?error=ajoute-failed");
        }
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createOrUpdateClient(request, response);
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createOrUpdateClient(request, response);
    }



    private void editClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        Optional<Client> client = getClientByCode(code);
        if (client.isPresent()) {
            request.setAttribute("client", client.get());
            request.getRequestDispatcher("/View/Clients/editClient.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/Clients");
        }
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        boolean deleted = serviceClient.deleteClient(code);
        if (deleted) {
            response.sendRedirect(request.getContextPath() + "/Clients");
        } else {
            response.sendRedirect("/Clients?error=delete-failed");
        }
    }

    private Optional<Client> getClientByCode(String code) {
        if (code != null) {
            return serviceClient.getClientByCode(code);
        } else {
            return Optional.empty();
        }
    }



}


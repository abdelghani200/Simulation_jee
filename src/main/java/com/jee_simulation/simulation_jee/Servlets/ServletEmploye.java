package com.jee_simulation.simulation_jee.Servlets;

import com.jee_simulation.simulation_jee.Dao.ImEmploye;
import com.jee_simulation.simulation_jee.Dto.Employe;
import com.jee_simulation.simulation_jee.Services.ServiceEmploye;
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

@WebServlet("/Employes")
public class ServletEmploye extends HttpServlet {

    private final ServiceEmploye serviceEmploye;


    public ServletEmploye() throws SQLException {
        this.serviceEmploye = new ServiceEmploye(new ImEmploye());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listesEmployes(req, resp);
        String action = req.getParameter("action");

        if(action == null){
            action = "list";
        }

        switch (action){

            case "edit":
                editEmploye(req, resp);
                break;
            case "update":
                updateEmploye(req, resp);
                break;
            case "add":
                addEmploye(req, resp);
                break;
            case "delete":
                deleteEmploye(req, resp);
                break;
            case "search":
                chercheClients(req, resp);
                break;
            default:


        }

    }

    private void listesEmployes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employe> employes = serviceEmploye.getAllEmployes();
        request.setAttribute("employes", employes);
        //response.getWriter().println(employes);
        request.getRequestDispatcher("/View/Employes/listeEmployes.jsp").forward(request, response);
    }

    private void chercheClients(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String query = request.getParameter("query");

        Optional<Employe> searchResult = serviceEmploye.findEmployeByEmailOrNomOrPrenom(query);

        if (searchResult.isPresent()) {
            List<Employe> employeList = new ArrayList<>();
            employeList.add(searchResult.get());
            request.setAttribute("clients", employeList);
        } else {
            System.out.println("Aucun résultat trouvé.");
        }

        //request.getRequestDispatcher("/View/Clients/listeClients.jsp").forward(request, response);
    }



    private void editEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricule = request.getParameter("matricule");
        if (matricule != null) {
            Optional<Employe> employes = serviceEmploye.getEmployeByMatricule(matricule);
            if (employes.isPresent()) {
                Employe employe = employes.get();
                System.out.println("Debug: Found employee for matricule " + matricule);
                request.setAttribute("employe", employe);
                request.getRequestDispatcher("/View/Employes/editEmploye.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/Employes");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/Employes");
        }
    }


    private void deleteEmploye(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String matricule = request.getParameter("matricule");
        if (matricule != null) {
            boolean deleted = serviceEmploye.deleteEmploye(matricule);
            if (deleted) {
                response.sendRedirect(request.getContextPath() + "/Employes");
            } else {
                response.sendRedirect("/Employes?error=delete-failed");

            }
        } else {
            response.sendRedirect(request.getContextPath() + "/Employes");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private void addEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricule = request.getParameter("matricule");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        LocalDate datenaissance = LocalDate.parse(request.getParameter("datenaissance"));
        String telephone = request.getParameter("telephone");
        String adressemail = request.getParameter("adresseEmail");
        LocalDate daterecrutement = LocalDate.parse(request.getParameter("daterecrutement"));

        Employe employe = new Employe(nom, prenom, datenaissance, telephone,matricule, adressemail,daterecrutement);
        Optional<Employe> addedClient = serviceEmploye.saveEmploye(employe);

        if (addedClient.isPresent()) {
            response.sendRedirect(request.getContextPath() + "/Employes?action=list");
        } else {
            response.sendRedirect("/Employes?error=ajoute-failed");

        }
    }

    private void updateEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricule = request.getParameter("matricule");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        LocalDate datenaissance = LocalDate.parse(request.getParameter("datenaissance"));
        LocalDate daterecrutement = LocalDate.parse(request.getParameter("daterecrutement"));
        String telephone = request.getParameter("telephone");
        String adresseEmail = request.getParameter("adresseEmail");


        Employe employe = new Employe(nom, prenom, datenaissance, telephone,matricule, adresseEmail,daterecrutement);

        boolean updatedClient = serviceEmploye.updateEmploye(employe);

        if (updatedClient) {
            response.sendRedirect(request.getContextPath() + "/Employes?action=list");
        } else {
            response.sendRedirect("/Employes?error=update-failed");
        }
    }



}


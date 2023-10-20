package com.jee_simulation.simulation_jee.Dao;

import com.jee_simulation.simulation_jee.Dto.Client;
import com.jee_simulation.simulation_jee.Interfaces.IClient;
import com.jee_simulation.simulation_jee.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImClient extends ImPersonne<Client> implements IClient {

    public Optional<Client> findByCode(String code) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Client.class, code));
        }
    }


    public List<Client> readAll() {

        List<Client> clientList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            clientList = session.createQuery("from Client ", Client.class).list();
        } catch (Exception e) {
            System.out.println("error message: " + e.getMessage());
            e.printStackTrace();
        }
        return clientList;
    }



    public boolean deleteClient(String code) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, code);
            if (client != null) {
                session.delete(client);
                transaction.commit();
                return true;
            }
            return false;
        }
    }

    public boolean update(Client client) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
            return true;
        }
    }

    @Override
    public Optional<Client> findByEmailOrNomOrPrenom(String searchValue) {
        return Optional.empty();
    }

    @Override
    public Optional<Client> findById(int id) {
        return Optional.empty();
    }

    // ...
}

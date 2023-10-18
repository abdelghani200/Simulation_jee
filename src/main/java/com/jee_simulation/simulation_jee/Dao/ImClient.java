package com.jee_simulation.simulation_jee.Dao;

import com.jee_simulation.simulation_jee.Dto.Client;
import com.jee_simulation.simulation_jee.Dto.Personne;
import com.jee_simulation.simulation_jee.Interfaces.IClient;
import com.jee_simulation.simulation_jee.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


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
        List<Client> clients = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Client> clientQuery = session.createQuery("FROM Client", Client.class);
            clients = clientQuery.list();

            for (Client client : clients) {
                int personneId = client.getId(); // Supposons que vous stockez l'ID de la personne dans le client

                // Chargez la personne associée au client
                Query<Personne> personneQuery = session.createQuery("FROM Personne WHERE id = :id", Personne.class);
                personneQuery.setParameter("id", personneId);
                Personne personne = personneQuery.uniqueResult();

                if (personne != null) {
                    client.setNom(personne.getNom());
                    client.setPrenom(personne.getPrenom());
                    client.setTelephone(personne.getTelephone());

                    if (personne instanceof Client) {
                        Client associatedClient = (Client) personne;
                        client.setAdresse(associatedClient.getAdresse());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Affichez l'erreur
        }
        return clients;
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

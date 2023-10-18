package com.jee_simulation.simulation_jee.Dao;

import com.jee_simulation.simulation_jee.Dto.Personne;
import com.jee_simulation.simulation_jee.Interfaces.IPersonne;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.jee_simulation.simulation_jee.Util.HibernateUtil;

import java.util.Optional;

public class ImPersonne<T extends Personne> implements IPersonne<T> {

    @Override
    public Optional<T> save(T personne) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(personne);
                transaction.commit();
                return Optional.of(personne);
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                System.out.println("Une erreur Hibernate s'est produite : " + e.getMessage());
            }
        }
        return Optional.empty();
    }
}

package com.jee_simulation.simulation_jee.Dao;

import com.jee_simulation.simulation_jee.Dto.Employe;
import com.jee_simulation.simulation_jee.Dto.Personne;
import com.jee_simulation.simulation_jee.Interfaces.IEmploye;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.jee_simulation.simulation_jee.Util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImEmploye extends ImPersonne<Employe> implements IEmploye {

    @Override
    public Optional<Employe> findByMatricule(String matricule) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.createQuery("FROM Employe WHERE matricule = :matricule", Employe.class)
                    .setParameter("matricule", matricule)
                    .setMaxResults(1)
                    .uniqueResult());
        }
    }

    @Override
    public Optional<Employe> findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Employe.class, id));
        }
    }

    @Override
    public Optional<Employe> save(Employe employe) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(employe);
                transaction.commit();
                return Optional.of(employe);
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                System.out.println("Une erreur Hibernate s'est produite : " + e.getMessage());
            }
        }
        return Optional.empty();
    }


    @Override
    public Optional<List<Employe>> readAllEmployes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Employe> query = criteriaBuilder.createQuery(Employe.class);
            Root<Employe> employeRoot = query.from(Employe.class);
            query.select(employeRoot);
            query.distinct(true); // Utilisez distinct pour éviter les doublons si plusieurs employés pointent vers la même personne.

            // Utilisez une jointure pour charger les données de Personne
            employeRoot.fetch("personne", JoinType.INNER);

            List<Employe> employes = session.createQuery(query).getResultList();
            return Optional.ofNullable(employes);
        } catch (Exception e) {
            e.printStackTrace(); // Affichez l'erreur
        }
        return Optional.empty();
    }



    @Override
    public boolean deleteEmploye(String matricule) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employe employe = findByMatricule(matricule).orElse(null);
            if (employe != null) {
                try {
                    session.remove(employe);
                    transaction.commit();
                    return true;
                } catch (Exception e) {
                    if (transaction != null && transaction.isActive()) {
                        transaction.rollback();
                    }
                    System.out.println("Une erreur Hibernate s'est produite : " + e.getMessage());
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(Employe employe) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(employe);
                transaction.commit();
                return true;
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                System.out.println("Une erreur Hibernate s'est produite : " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Optional<Employe> findByEmailOrNomOrPrenom(String searchValue) {
        return Optional.empty();
    }

    @Override
    public Optional<Employe> changeAgence(Employe employe, String code_agence) {
        return Optional.empty();
    }

}

package com.jee_simulation.simulation_jee.Dao;

import com.jee_simulation.simulation_jee.Dto.Credit;
import com.jee_simulation.simulation_jee.Enums.EtatCredit;
import com.jee_simulation.simulation_jee.Interfaces.ICredit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ImCredit implements ICredit {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("yourPersistenceUnit");
    private EntityManager em = emf.createEntityManager();


    @Override
    public Optional<Credit> create(Credit credit) {
        em.getTransaction().begin();
        em.persist(credit);
        em.getTransaction().commit();
        return Optional.of(credit);
    }

    @Override
    public List<Credit> read() {
        String sql = "SELECT c FROM Credit c";
        List<Credit> creditList = em.createQuery(sql, Credit.class).getResultList();
        return creditList;
    }

    @Override
    public boolean update(int numero, EtatCredit etat) {
        em.getTransaction().begin();
        String jpql = "UPDATE Credit c SET c.etat = :etat WHERE c.numero = :numero";
        int updatedCount = em.createQuery(jpql)
                .setParameter("etat", etat)
                .setParameter("numero", numero)
                .executeUpdate();
        em.getTransaction().commit();
        return updatedCount > 0;
    }

    @Override
    public List<Credit> getByEtat(EtatCredit etat) {
        String jpql = "SELECT c FROM Credit c WHERE c.etat = :etat";
        return em.createQuery(jpql, Credit.class)
                .setParameter("etat", etat)
                .getResultList();
    }

    @Override
    public List<Credit> getByDate(LocalDate date) {
        String jpql = "SELECT c FROM Credit c WHERE c.date = :date";
        return em.createQuery(jpql, Credit.class)
                .setParameter("date", date)
                .getResultList();
    }

}

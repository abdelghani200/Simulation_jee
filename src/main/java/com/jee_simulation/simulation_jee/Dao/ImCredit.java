package com.jee_simulation.simulation_jee.Dao;

import com.jee_simulation.simulation_jee.Dto.Credit;
import com.jee_simulation.simulation_jee.Enums.EtatCredit;
import com.jee_simulation.simulation_jee.Interfaces.ICredit;
import com.jee_simulation.simulation_jee.Util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImCredit implements ICredit {




    @Override
    public Optional<Credit> create(Credit credit) {

        return Optional.of(credit);
    }

    @Override
    public List<Credit> read() {
        List<Credit> creditList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            creditList = session.createQuery("from Credit ", Credit.class).list();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return creditList;
    }

    @Override
    public boolean update(int numero, EtatCredit etat) {

        return false;
    }

    @Override
    public List<Credit> getByEtat(EtatCredit etat) {

        return null;
    }

    @Override
    public List<Credit> getByDate(LocalDate date) {

        return null;
    }

}

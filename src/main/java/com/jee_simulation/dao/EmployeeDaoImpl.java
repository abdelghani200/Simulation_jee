package com.jee_simulation.dao;

import java.util.List;
import java.util.Optional;

import com.jee_simulation.dao.interfaces.EmployeeDao;
import com.jee_simulation.entities.Employee;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@ApplicationScoped
@Priority(1)
public class EmployeeDaoImpl implements EmployeeDao {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Employee> read() {

        return entityManager.createQuery("FROM Employee", Employee.class)
                            .getResultList();

    }

    @Override
    public Optional<Employee> find(Integer identifier) {

        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            Employee foundedEmployee = entityManager.find(Employee.class, identifier);
            transaction.commit();
            return Optional.of(foundedEmployee);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }
    
}

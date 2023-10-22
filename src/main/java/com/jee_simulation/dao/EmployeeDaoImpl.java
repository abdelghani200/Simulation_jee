package com.jee_simulation.dao;

import java.util.List;
import java.util.Optional;

import com.jee_simulation.dao.interfaces.EmployeeDao;
import com.jee_simulation.entities.Employee;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@ApplicationScoped
@Named("employee_dao_hibernate_implementation")
public class EmployeeDaoImpl implements EmployeeDao {

    @Inject
    private final EntityManager entityManager;

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
            return Optional.of(foundedEmployee)
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }
    
}

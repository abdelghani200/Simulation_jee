package com.jee_simulation.services;

import com.jee_simulation.dao.interfaces.EmployeeDao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class EmployeeService {
    
    @Inject
    @Named("Employee_dao_Hibernate_imlementation")
    private EmployeeDao employeeDao;

}

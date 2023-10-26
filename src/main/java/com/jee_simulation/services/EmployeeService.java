package com.jee_simulation.services;

import java.util.List;

import com.jee_simulation.dao.interfaces.EmployeeDao;
import com.jee_simulation.jsonbAddapters.EmployeeAdapter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;

@ApplicationScoped
public class EmployeeService {
    
    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private EmployeeAdapter employeeAdapter;

    public List<JsonObject> getAllAsJson() {

        try {
            return employeeAdapter.adaptToJson(employeeDao.read());
        } catch (Exception e) { e.printStackTrace(); }
        return null;

    }

    public JsonObject findAsJson(int employeeId) {

        try {
            return employeeAdapter.adaptToJson( employeeDao.find(employeeId).orElse(null) );
        } catch (Exception e) { e.printStackTrace(); }
        return null;
        
    }

    

}

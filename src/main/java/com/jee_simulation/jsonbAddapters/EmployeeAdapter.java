package com.jee_simulation.jsonbAddapters;

import java.util.ArrayList;
import java.util.List;

import com.jee_simulation.entities.Employee;

import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.bind.adapter.JsonbAdapter;

public class EmployeeAdapter implements JsonbAdapter<Employee, JsonObject> {

    @Inject
    private AgencyAdapter agencyAdapter;

    @Override
    public JsonObject adaptToJson(Employee obj) throws Exception {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id", obj.getId());
        builder.add("email", obj.getEmail());
        builder.add("recruitment_date", obj.getRecruitmentDate().toString());
        builder.add("first_name", obj.getFirstName());
        builder.add("last_name", obj.getLastName());
        builder.add("birth_date", obj.getBirthDate().toString());
        builder.add("phone_number", obj.getPhoneNumber());
        builder.add("agency", agencyAdapter.adaptToJson( obj.getAgency() ));
        return builder.build();
    }

    public List<JsonObject> adaptToJson(List<Employee> list) throws Exception {
        List<JsonObject> newList = new ArrayList<>();
        for (Employee employee : list) {
            newList.add( adaptToJson(employee) );
        } 
        return newList;
    }
    
    @Override
    public Employee adaptFromJson(JsonObject obj) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'adaptFromJson'");
    }

}

package com.jee_simulation.jsonbAddapters;

import java.util.ArrayList;
import java.util.List;

import com.jee_simulation.entities.Client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.bind.adapter.JsonbAdapter;

@ApplicationScoped
public class ClientAdapter implements JsonbAdapter<Client, JsonObject> {

    @Inject
    private EmployeeAdapter employeeAdapter;

    @Override
    public JsonObject adaptToJson(Client obj) throws Exception {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id", obj.getId());
        builder.add("address", obj.getAddress());
        builder.add("first_name", obj.getFirstName());
        builder.add("last_name", obj.getLastName());
        builder.add("birth_date", obj.getBirthDate().toString());
        builder.add("phone_number", obj.getPhoneNumber());
        builder.add("employee", employeeAdapter.adaptToJson( obj.getEmployee() ));
        return builder.build();
    }
    
    public List<JsonObject> adaptToJson(List<Client> list) throws Exception {
        List<JsonObject> newList = new ArrayList<>();
        for (Client client : list) {
            newList.add( adaptToJson(client) );
        } 
        return newList;
    }

    @Override
    public Client adaptFromJson(JsonObject obj) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'adaptFromJson'");
    }
    
}

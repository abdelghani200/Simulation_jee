package com.jee_simulation.jsonbAddapters;

import java.util.ArrayList;
import java.util.List;

import com.jee_simulation.entities.Agency;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.bind.adapter.JsonbAdapter;

@ApplicationScoped
public class AgencyAdapter implements JsonbAdapter<Agency, JsonObject> {

    @Override
    public JsonObject adaptToJson(Agency obj) throws Exception {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id", obj.getId());
        builder.add("name", obj.getName());
        builder.add("address", obj.getAddress());
        builder.add("phone_number", obj.getPhoneNumber());
        return builder.build();
    }

    
    public List<JsonObject> adaptToJson(List<Agency> list) throws Exception {
        List<JsonObject> newList = new ArrayList<>();
        for (Agency agency : list) {
            newList.add( adaptToJson(agency) );
        } 
        return newList;
    }
    
    @Override
    public Agency adaptFromJson(JsonObject obj) throws Exception {

        throw new UnsupportedOperationException("Unimplemented method 'adaptFromJson'");

    }
    
}

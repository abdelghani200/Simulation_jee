package com.jee_simulation.services;


import java.util.List;

import com.jee_simulation.dao.interfaces.ClientDao;
import com.jee_simulation.utilities.jsonbAddapters.ClientAdapter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;

@ApplicationScoped
public class ClientService {
    
    @Inject
    private ClientDao clientDao;

    @Inject
    private ClientAdapter clientAdapter;

    public List<JsonObject> getAllAsJson() {

        try {
            return clientAdapter.adaptToJson( clientDao.read() );
        } catch (Exception e) { e.printStackTrace(); }
        return null;

    }

    public JsonObject findAsJson(int clientId) {

        try {
            return clientAdapter.adaptToJson( clientDao.find(clientId).orElse(null) );
        } catch (Exception e) { e.printStackTrace(); }
        return null;

    }

}

package com.jee_simulation.jsonbAddapters;

import com.jee_simulation.entities.CreditRequest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.bind.adapter.JsonbAdapter;

@ApplicationScoped
public class CreditRequestAdapter implements JsonbAdapter<CreditRequest, JsonObject> {

    @Inject
    private AgencyAdapter agencyAdapter;
    
    @Inject
    private ClientAdapter clientAdapter;

    @Override
    public JsonObject adaptToJson(CreditRequest obj) throws Exception {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("id", obj.getId());
        builder.add("duration", obj.getDuration());
        builder.add("request_date", obj.getRequestDate().toString());
        builder.add("borrowed_amount", obj.getBorrowedAmount());
        builder.add("monthly_amount", obj.getMonthlyAmount());
        builder.add("remark", obj.getRemark());
        builder.add("review_date", obj.getReviewDate().toString());
        builder.add("status", obj.getStatus().toString());
        builder.add("agency", agencyAdapter.adaptToJson(obj.getAgency()));
        builder.add("client", clientAdapter.adaptToJson( obj.getClient() ));
        return builder.build();
    }

    @Override
    public CreditRequest adaptFromJson(JsonObject obj) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'adaptFromJson'");
    }
    
}

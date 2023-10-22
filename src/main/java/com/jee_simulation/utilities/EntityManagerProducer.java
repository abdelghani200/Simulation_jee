package com.jee_simulation.utilities;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
    
    private static final String PERSISTENCE_UNIT_NAME = "postgreSQL_persistence_unit";

    private static EntityManagerFactory factory;

    @Produces
    public static EntityManager getEntityManager() {
        if(factory == null)
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        return factory.createEntityManager();
    }


    public static boolean closeFactory() {
        if(factory == null)
            return false;
        factory.close();
        return true;
    }
}

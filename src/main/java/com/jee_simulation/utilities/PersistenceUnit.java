package com.jee_simulation.utilities;

import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

public class PersistenceUnit implements PersistenceUnitInfo {

    @Override
    public String getPersistenceUnitName() { return "postgreSQL_persistence_unit"; }

    @Override
    public String getPersistenceProviderClassName() { return "org.hibernate.jpa.HibernatePersistenceProvider"; }

    @Override
    public PersistenceUnitTransactionType getTransactionType() { return PersistenceUnitTransactionType.RESOURCE_LOCAL; }

    @Override
    public DataSource getJtaDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/EasyBank_web");
        dataSource.setUsername("mizo");
        dataSource.setPassword("password");

        return dataSource;
    }
    
    @Override
    public boolean excludeUnlistedClasses() { return false; }

    @Override
    public DataSource getNonJtaDataSource() { return null; }

    @Override
    public List<String> getMappingFileNames() { return null; }

    @Override
    public List<URL> getJarFileUrls() { return null; }

    @Override
    public URL getPersistenceUnitRootUrl() { return null; }

    @Override
    public List<String> getManagedClassNames() { return null; }

    @Override
    public SharedCacheMode getSharedCacheMode() { return null; }

    @Override
    public ValidationMode getValidationMode() { return null; }

    @Override
    public Properties getProperties() { return null; }

    @Override
    public String getPersistenceXMLSchemaVersion() { return null; }

    @Override
    public ClassLoader getClassLoader() { return null; }

    @Override
    public void addTransformer(ClassTransformer transformer) {}

    @Override
    public ClassLoader getNewTempClassLoader() { return null; }
    
}

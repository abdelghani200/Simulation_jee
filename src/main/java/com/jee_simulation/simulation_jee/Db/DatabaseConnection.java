package com.jee_simulation.simulation_jee.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {


    private static Connection connection = null;

    public static Connection getConnection(){
        try{
            String url = "jdbc:postgresql://localhost:5432/Gestion_Bancaire";
            String user = "postgres";
            String password = "youcode2023";
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}

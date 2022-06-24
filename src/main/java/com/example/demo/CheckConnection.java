package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@RestController
public class CheckConnection {

    @Autowired
    Environment environment;

    @GetMapping("/checkConnection")
    public String checkConnection()   {
        String str =" ";
        try{
            Connection conn = getConnection();
            conn.close();
            str = "Connection Success!!";
        } catch (Exception e){
           str =  e.getMessage() +  " Connection failed!! " + environment.getProperty("jdbc.user") + " " + environment.getProperty("jdbc.password") +  " " + environment.getProperty("jdbc.url");
        }
        return str;

    }

    private Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", environment.getProperty("jdbc.user"));
        connectionProps.put("password", environment.getProperty("jdbc.password"));

        conn = DriverManager.getConnection(
                environment.getProperty("jdbc.url"),
                connectionProps);
        return  conn;
    }
}

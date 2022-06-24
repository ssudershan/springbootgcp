package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    Environment env;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @RequestMapping
    public String home(){
        return "hello gcp:" +"jdbcuser=" + env.getProperty("jdbc.user")+ " jdbcpassword=" + env.getProperty("jdbc.password")+ "jdbcurl=" + env.getProperty("jdbc.url");
    }

}

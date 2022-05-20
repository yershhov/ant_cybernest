package com.gmail.yershhov.ant_cybernest;

import com.gmail.yershhov.ant_cybernest.dao.UserRepository;
import com.gmail.yershhov.ant_cybernest.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AntCybernestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntCybernestApplication.class, args);
    }

}

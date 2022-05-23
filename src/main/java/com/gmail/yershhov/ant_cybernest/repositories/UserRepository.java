package com.gmail.yershhov.ant_cybernest.repositories;

import com.gmail.yershhov.ant_cybernest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmail(String email);
}

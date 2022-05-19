package com.gmail.yershhov.ant_cybernest.dao;

import com.gmail.yershhov.ant_cybernest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

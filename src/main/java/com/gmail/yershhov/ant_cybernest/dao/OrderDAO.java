package com.gmail.yershhov.ant_cybernest.dao;


import com.gmail.yershhov.ant_cybernest.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Order order) {
        jdbcTemplate.update("insert into orders values(default, ?, ?, ?, ?, ?, ?, ?)",
                order.getGame(), order.getName(), order.getSurname(), order.getEmail(),
                order.getPhone(), order.getExperience(), order.getPreferredRole());
    }


}

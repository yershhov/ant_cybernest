package com.gmail.yershhov.ant_cybernest.dao;


import com.gmail.yershhov.ant_cybernest.entities.CsOrder;
import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import com.gmail.yershhov.ant_cybernest.entities.Order;
import com.gmail.yershhov.ant_cybernest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO {

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public OrderDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    //        jdbcTemplate.update("insert into users values(default, ?, ?, ?, ?, ?)",
////                order.getGame(), order.getUser().getFullName(), order.getUser().getEmail(),
////                order.getUser().getPhone(), order.getUser().getExperience());
//    public void save(CsOrder order) {
//
//    }
//    public void save(DotaOrder order){
//            System.out.println(order.getGame());
//            System.out.println(order.getUser().getFullName());
//            System.out.println(order.getUser().getEmail());
//            System.out.println(order.getUser().getPhone());
//            System.out.println(order.getUser().getExperience());
//            System.out.println(order.getRole());
//            System.out.println(order.getCommunication());
//    }
//

}

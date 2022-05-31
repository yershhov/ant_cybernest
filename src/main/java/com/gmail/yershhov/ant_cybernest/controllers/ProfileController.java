package com.gmail.yershhov.ant_cybernest.controllers;

import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import com.gmail.yershhov.ant_cybernest.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ProfileController {
    @Getter
    @Setter
    private static User loggedInUser;
    private final JdbcTemplate jdbcTemplate;

    public ProfileController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/profile")
    public String profile(Model model1, Model model2){
        model1.addAttribute("loggedInUser", loggedInUser);
        model2.addAttribute("dotaOrders", jdbcTemplate.query("select * from dota_order where user_id=?", new BeanPropertyRowMapper<>(DotaOrder.class), loggedInUser.getUserId()));
        return "profile";
    }
}

package com.gmail.yershhov.ant_cybernest.controllers;

import com.gmail.yershhov.ant_cybernest.entities.CsOrder;
import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import com.gmail.yershhov.ant_cybernest.entities.User;
import com.gmail.yershhov.ant_cybernest.repositories.DotaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping()
public class ProfileController {
    @Getter
    @Setter
    private static User loggedInUser;
    private final JdbcTemplate jdbcTemplate;
    private final DotaRepository dotaRepository;
    public ProfileController(JdbcTemplate jdbcTemplate, DotaRepository dotaRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.dotaRepository = dotaRepository;
    }

    @GetMapping("/profile")
    public String profile(Model model1, Model model2, Model model3, Model model4){
        model1.addAttribute("loggedInUser", loggedInUser);
        model2.addAttribute("dotaOrders", jdbcTemplate.query("select * from dota_order where user_id=?", new BeanPropertyRowMapper<>(DotaOrder.class), loggedInUser.getUserId()));
        model3.addAttribute("updatedDotaOrder", new DotaOrder());
        model4.addAttribute("updatedCsOrder", new CsOrder());
        return "profile";
    }
    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("updatedDotaOrder") @Valid DotaOrder updatedDotaOrder, @ModelAttribute("loggedInUser") User user){
        jdbcTemplate.update("UPDATE dota_order SET user_experience=?, role=?, communication=?" +
                " WHERE order_id=?", updatedDotaOrder.getUserExperience(), updatedDotaOrder.getRole(),updatedDotaOrder.getCommunication(), id);
        return "redirect:/profile";
    }
}

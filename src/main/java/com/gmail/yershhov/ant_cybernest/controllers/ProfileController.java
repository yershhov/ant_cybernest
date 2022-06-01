package com.gmail.yershhov.ant_cybernest.controllers;

import com.gmail.yershhov.ant_cybernest.entities.CsOrder;
import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import com.gmail.yershhov.ant_cybernest.entities.User;
import com.gmail.yershhov.ant_cybernest.repositories.DotaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

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
    public String profile(Model model1, Model model2, Model model3, Model model4, Model model5, Model model6){
        model1.addAttribute("loggedInUser", loggedInUser);
        model2.addAttribute("dotaOrders", jdbcTemplate.query("select * from dota_order where user_id=?", new BeanPropertyRowMapper<>(DotaOrder.class), loggedInUser.getUserId()));
        model6.addAttribute("csOrders", jdbcTemplate.query("select * from cs_order where user_id=?", new BeanPropertyRowMapper<>(CsOrder.class), loggedInUser.getUserId()));
        model3.addAttribute("updatedDotaOrder", new DotaOrder());
        model4.addAttribute("updatedCsOrder", new CsOrder());
        model5.addAttribute("updatedUser", new User());
        return "profile";
    }
    @PatchMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Integer id, @ModelAttribute("updatedUser") User user) throws NoSuchAlgorithmException {
        jdbcTemplate.update("update app_user set full_name=?,phone=?, password=?", user.getFullName(), user.getPhone(), Encryptor.encrypt(user.getPassword()));
        ProfileController.setLoggedInUser(jdbcTemplate.queryForObject("select * from app_user where user_id=?", new BeanPropertyRowMapper<>(User.class), id));
        return "redirect:/profile";
    }
    @PatchMapping("/updateDota/{id}")
    public String updateDota(@PathVariable("id") Integer id, @ModelAttribute("updatedDotaOrder") @Valid DotaOrder updatedDotaOrder, @ModelAttribute("loggedInUser") User user){
        jdbcTemplate.update("UPDATE dota_order SET user_experience=?, role=?, communication=?" +
                " WHERE order_id=?", updatedDotaOrder.getUserExperience(), updatedDotaOrder.getRole(),updatedDotaOrder.getCommunication(), id);
        return "redirect:/profile";
    }

    @DeleteMapping("/deleteDotaOrder/{id}")
    public String deleteDota(@PathVariable("id") Integer id){
        jdbcTemplate.update("delete from dota_order where order_id=?", id);
        return "redirect:/profile";
    }
    @PatchMapping("/updateCs/{id}")
    public String updateDota(@PathVariable("id") Integer id, @ModelAttribute("updatedCsOrder") @Valid CsOrder updatedCsOrder, @ModelAttribute("loggedInUser") User user){
        jdbcTemplate.update("UPDATE cs_order SET user_experience=?, hours_played=?, best_map=?, win_rate=?" +
                " WHERE order_id=?", updatedCsOrder.getUserExperience(), updatedCsOrder.getHoursPlayed(),updatedCsOrder.getBestMap(), updatedCsOrder.getWinRate(), id);
        return "redirect:/profile";
    }

    @DeleteMapping("/deleteCsOrder/{id}")
    public String deleteCs(@PathVariable("id") Integer id){
        jdbcTemplate.update("delete from cs_order where order_id=?", id);
        return "redirect:/profile";
    }

}

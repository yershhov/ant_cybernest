package com.gmail.yershhov.ant_cybernest.controllers;

import com.gmail.yershhov.ant_cybernest.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ProfileController {
    private static User loggedInUser;
    @GetMapping("/profile")
    public String profile(Model model){
        model.addAttribute("loggedInUser", loggedInUser);
        return "profile";
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        ProfileController.loggedInUser = loggedInUser;
    }
}

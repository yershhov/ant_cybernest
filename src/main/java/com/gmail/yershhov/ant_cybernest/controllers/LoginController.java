package com.gmail.yershhov.ant_cybernest.controllers;

import com.gmail.yershhov.ant_cybernest.repositories.UserRepository;
import com.gmail.yershhov.ant_cybernest.entities.UserToLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userToLogin", new UserToLogin());
        return "login";
    }
    @PostMapping("/log")
    public String log(@ModelAttribute("userToLogin") UserToLogin userToLogin){
        if(userRepository.findByEmail(userToLogin.getEmail()).size() == 0){
            System.out.println("No user with such email found");
            return "redirect:/registration";
        }
        ProfileController.setLoggedInUser(userRepository.findByEmail(userToLogin.getEmail()).get(0));
        return "redirect:/profile";
    }
}

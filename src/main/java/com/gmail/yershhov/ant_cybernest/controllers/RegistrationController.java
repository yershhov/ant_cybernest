package com.gmail.yershhov.ant_cybernest.controllers;

import com.gmail.yershhov.ant_cybernest.repositories.UserRepository;
import com.gmail.yershhov.ant_cybernest.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class RegistrationController {
    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute @Valid User user,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration";
        }
        userRepository.save(user);
        return "redirect:/home";
    }

}

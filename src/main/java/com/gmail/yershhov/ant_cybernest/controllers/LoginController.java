package com.gmail.yershhov.ant_cybernest.controllers;

import com.gmail.yershhov.ant_cybernest.repositories.UserRepository;
import com.gmail.yershhov.ant_cybernest.entities.UserToLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping()
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping()
    public String login(Model model){
        model.addAttribute("userToLogin", new UserToLogin());
        return "login";
    }
    @PostMapping("/log")
    public String log(@ModelAttribute("userToLogin") @Valid UserToLogin userToLogin,
                      BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            userToLogin.setIsValid(false);
            return "login";
        }
        userToLogin.setIsValid(true);
        ProfileController.setLoggedInUser(userRepository.findByEmail(userToLogin.getEmail()).get(0));
        return "redirect:/profile";
    }
}

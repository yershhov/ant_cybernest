package com.gmail.yershhov.ant_cybernest.controllers;
import com.gmail.yershhov.ant_cybernest.entities.CsOrder;
import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import com.gmail.yershhov.ant_cybernest.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String index(Model model1, Model model2, Model model3) {
        model1.addAttribute("csorder", new CsOrder());
        model2.addAttribute("user", ProfileController.getLoggedInUser());
        model3.addAttribute("dotaorder", new DotaOrder());
        return "index";
    }

    @PostMapping("/cspost")
    public String save(@ModelAttribute("user") User user, @ModelAttribute("csorder") CsOrder csOrder) {
        csOrder.setGame("CS:GO");
        return "redirect:/profile";
    }

    @PostMapping("/dotapost")
    public String save(@ModelAttribute("user") User user, @ModelAttribute("dotaorder") DotaOrder dotaOrder) {
        dotaOrder.setGame("Dota 2");
        return "redirect:/profile";
    }
}

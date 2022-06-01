package com.gmail.yershhov.ant_cybernest.controllers;
import com.gmail.yershhov.ant_cybernest.entities.CsOrder;
import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import com.gmail.yershhov.ant_cybernest.entities.User;
import com.gmail.yershhov.ant_cybernest.repositories.CsRepository;
import com.gmail.yershhov.ant_cybernest.repositories.DotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    private final DotaRepository dotaRepository;
    private final CsRepository csRepository;

    public IndexController(DotaRepository dotaRepository, CsRepository csRepository) {
        this.dotaRepository = dotaRepository;
        this.csRepository = csRepository;
    }

    @GetMapping("/home")
    public String index(Model model1, Model model3) {
        model1.addAttribute("csorder", new CsOrder());
        model3.addAttribute("dotaorder", new DotaOrder());
        return "index";
    }

    @PostMapping("/cspost")
    public String save(@ModelAttribute("csorder") CsOrder csOrder) {
        csOrder.setGame("CS:GO");
        csOrder.setUser(ProfileController.getLoggedInUser());
        csRepository.save(csOrder);
        return "redirect:/profile";
    }

    @PostMapping("/dotapost")
    public String save(@ModelAttribute("dotaorder") DotaOrder dotaOrder) {
        dotaOrder.setGame("DOTA");
        dotaOrder.setUser(ProfileController.getLoggedInUser());
        dotaRepository.save(dotaOrder);
        return "redirect:/profile";
    }
}

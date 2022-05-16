package com.gmail.yershhov.ant_cybernest.controllers;

import com.gmail.yershhov.ant_cybernest.dao.OrderDAO;
import com.gmail.yershhov.ant_cybernest.entities.CsOrder;
import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import com.gmail.yershhov.ant_cybernest.entities.Order;
import com.gmail.yershhov.ant_cybernest.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {
    private final OrderDAO orderDAO;

    public IndexController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping()
    public String index(Model model1, Model model2, Model model3) {
        model1.addAttribute("csorder", new CsOrder());
        model2.addAttribute("user", new User());
        model3.addAttribute("dotaorder", new DotaOrder());
        return "index";
    }

    @PostMapping("/cspost")
    public String save(@ModelAttribute("user") User user, @ModelAttribute("csorder") CsOrder csOrder) {
        csOrder.setUser(user);
        orderDAO.save(csOrder);
        return "redirect:/response/success";
    }

    @PostMapping("/dotapost")
    public String save(@ModelAttribute("user") User user, @ModelAttribute("dotaorder") DotaOrder dotaOrder) {
        dotaOrder.setUser(user);
        orderDAO.save(dotaOrder);
        return "redirect:/response/success";
    }
}

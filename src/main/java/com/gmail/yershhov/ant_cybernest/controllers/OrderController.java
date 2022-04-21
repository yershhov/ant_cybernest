package com.gmail.yershhov.ant_cybernest.controllers;

import com.gmail.yershhov.ant_cybernest.dao.OrderDAO;
import com.gmail.yershhov.ant_cybernest.entities.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ordercourse")
public class OrderController {

    private final OrderDAO orderDAO;

    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping("/cs")
    public String csOrder(Model model) {
        model.addAttribute("order", new Order("cs"));
        return "csOrder";
    }

    @GetMapping("/dota")
    public String dotaOrder(Model model) {
        model.addAttribute("order", new Order("dota"));
        return "dotaOrder";
    }

    @PostMapping("/success")
    public String saveOrder(@ModelAttribute("order") Order order) {
        orderDAO.save(order);
        return "success";
    }

}

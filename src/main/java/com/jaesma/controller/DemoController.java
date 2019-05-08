package com.jaesma.controller;

import com.jaesma.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    // -- declare the service -- >
    private final DemoService demoService;

    // -- constructor injection of demoService -- >
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // localhost:8080/

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    // localhost:8080/welcome
    // localhost:8080/welcome?user=James
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age", age);
        return "welcome";
    }

    // -- model attributes -- >
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        return demoService.getWelcomeMessage(); // demoService getWelcomeMessage method called
    }
}

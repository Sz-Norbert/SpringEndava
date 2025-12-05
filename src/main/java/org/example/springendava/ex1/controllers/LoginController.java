package org.example.springendava.ex1.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springendava.ex1.models.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/")
    public String loginGet(){
        return "login.html";
    }

    private final LoginProcessor loginProcessor;

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();

        if (loggedIn){
            return "redirect:/main";
        }


        model.addAttribute("message", "Login failed!");
        return "login.html";

    }
}

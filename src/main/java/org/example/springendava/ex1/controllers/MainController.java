package org.example.springendava.ex1.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springendava.ex1.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model model
    ){

        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }
        String username = loggedUserManagementService.getUsername();
        if(username==null){
            return "redirect:/";
        }
        model.addAttribute("username" , username);


        return "main.html";
    }
}

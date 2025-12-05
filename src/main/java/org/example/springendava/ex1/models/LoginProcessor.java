package org.example.springendava.ex1.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.springendava.ex1.controllers.LoginController;
import org.example.springendava.ex1.services.LoggedUserManagementService;
import org.example.springendava.ex1.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Data
@RequiredArgsConstructor
public class LoginProcessor {

    private String username;
    private String password;

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;




    public boolean login() {
        loginCountService.incrementCount();
        String username = this.username;
        String password = this.password;
        boolean loginResult = false;
        if ("natalie".equals(username) && "password".equals(password)) {
            loginResult = true;
            loggedUserManagementService.setUsername(username);
        }
        return loginResult;


    }



}

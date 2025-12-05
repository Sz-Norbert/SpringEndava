package org.example.springendava.ex1.models;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Data
public class LoginProcessor {

    private String username;
    private String password;


    public boolean login() {

        String username = this.username;
        String password = this.password;

        if("natalie".equals(username) && "password".equals(password))
            return true;
        return false;
    }



}

package org.northernarc.securitydemo.controller;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String hellouser(){
//        return "Hello, World!";
        return "Hello user, you can only search products and place order!!";
    }

    @GetMapping(value = "/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloadmin(){
        return "Hello admin, you can add,delete,update products,orders and customers!!!";
    }

    @GetMapping("/loanofficer")
    @PreAuthorize("hasRole('LOAN_OFFICER')")
    public String helloloanofficer(){
        return "Hello loan officer, you can approve or reject the loan applications";
    }



}

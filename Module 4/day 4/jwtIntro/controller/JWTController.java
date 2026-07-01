package org.northernarc.jwtdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class JWTController {
    @GetMapping
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String helloUser() {
        return "Hello, User!";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloAdmin() {
        return "Hello, Admin!";
    }
}

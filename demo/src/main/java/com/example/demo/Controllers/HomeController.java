package com.example.demo.Controllers;

import com.example.demo.entities.User;
import com.example.demo.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private Userservice userservice;

    @GetMapping("/user")
    public List<User> getUser(){
        System.out.println("getting user data");
        return this.userservice.getUsers();
    }

    @GetMapping("/curr-user")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}

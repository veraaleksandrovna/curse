package com.example.demo.api;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.Registration;
import java.util.Objects;


@Controller
public class LoginController {


//    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody User login(@RequestParam String email, @RequestParam String password)
//    {
//
//    }

    @GetMapping("/login")
    public String showLogin()
    {
        return "login";
    }



}

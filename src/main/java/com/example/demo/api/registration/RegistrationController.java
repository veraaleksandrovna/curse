package com.example.demo.api.registration;

import com.example.demo.api.registration.RegistrationRequest;
import com.example.demo.api.registration.RegistrationService;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.Registration;

@Controller
@RequestMapping("registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request)
    {
        return service.register(request);
    }

    @GetMapping("/register")
    public String registrationForm(){
        return "registration";
    }
}

package com.example.demo.api.registration;

import com.example.demo.domain.FashUser;
import com.example.demo.domain.roles.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService service;

    @PostMapping("/register")
    public String register(@ModelAttribute("fashUser") FashUser user)
    {
        user.setRole(UserRole.USER);
        RegistrationRequest request = new RegistrationRequest(user);
        return service.register(request);
    }

    @GetMapping("/register")
    public String registrationForm(Model model){
        model.addAttribute("fashUser", new FashUser());
        return "registration";
    }
}

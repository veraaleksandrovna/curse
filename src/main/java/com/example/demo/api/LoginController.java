package com.example.demo.api;

import com.example.demo.api.registration.RegistrationRequest;
import com.example.demo.domain.FashUser;
import com.example.demo.domain.roles.UserRole;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
@AllArgsConstructor
public class LoginController {

    private final UserService service;

    @PostMapping("/login")
    public String register(@ModelAttribute("fashUser") FashUser user, HttpSession httpSession)
    {
        service.loadUserByUsername(user.getEmail());
        user.setRole(UserRole.USER);
        httpSession.setAttribute("user", user);
        return "hello";
    }

    @GetMapping("/login")
    public String registrationForm(Model model){
        model.addAttribute("fashUser", new FashUser());
        return "login";
    }

    @GetMapping("/u/hello")
    public String hello(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username","Hello " + auth.getName() + "!");
        return "hello";
    }

}

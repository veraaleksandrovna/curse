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
    public String logIn(@ModelAttribute("fashUser") FashUser user, HttpSession httpSession)
    {
        FashUser logged = (FashUser) service.loadUserByUsername(user.getUsername());
        System.out.println(logged.getId());
        System.out.println("poop");
        httpSession.setAttribute("user", logged);
        return "hello";
    }

    @GetMapping("/login")
    public String registrationForm(Model model){
        model.addAttribute("fashUser", new FashUser());
        return "login";
    }

    @GetMapping("/hello")
    public String which()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        FashUser user = (FashUser) auth.getPrincipal();
        if(user.getRole().equals(UserRole.ADMIN))
        {
            return "redirect:a/hello";
        }
        else {
            return "redirect:u/hello";
        }
    }
}

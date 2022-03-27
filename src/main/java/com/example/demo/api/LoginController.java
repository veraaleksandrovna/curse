package com.example.demo.api;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password)
    {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user = userService.log_in(user);
        return "redirect:home";
    }

    @GetMapping("/login")
    public String showLogin()
    {
        return "login";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user)
    {
        user.setRole("user");
        userService.regiserNewUser(user);
        return "redirect:login";
    }

    @GetMapping("/register")
    public String registrationGet(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
}

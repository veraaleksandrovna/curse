package com.example.demo.api;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public String show(){
//        return "index";
//    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password)
    {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user = userService.log_in(user);
        Session.Cookie cookie = new Session.Cookie();
        cookie.setName("userData");
        cookie.setComment(user.getUsername() + '\n' + user.getEmail());
        return "redirect:home";
    }

    @GetMapping("/login")
    public String showLogin()
    {
        return "login";
    }


    @PostMapping("/register")
    public String registerr(@RequestParam String username, @RequestParam String email, @RequestParam String password)
    {
        User user = new User();
        user.setRole("user");
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userService.regiserNewUser(user);
        return "redirect:login";
    }

    @GetMapping("/register")
    public String show(){
        return "registration";
    }
}

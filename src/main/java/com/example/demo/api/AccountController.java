package com.example.demo.api;

import com.example.demo.domain.Client;
import com.example.demo.domain.FashUser;
import com.example.demo.domain.Piece;
import com.example.demo.service.ClientService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class AccountController {

    private final ClientService clientService;
    private final UserService userService;

    @GetMapping("/u/account")
    public String account(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        FashUser user = (FashUser) auth.getPrincipal();
        Client client = clientService.getClientByUser((FashUser) auth.getPrincipal());

        model.addAttribute("user", user);
        model.addAttribute("client" ,client);

        return "myAccount";
    }

    @PostMapping("u/account")
    public String uChange(@RequestParam("flag") char flag ,@ModelAttribute("user") FashUser userUpdt, @ModelAttribute("client") Client clientUpdt, Model model)
    {
        if(flag=='u')
        {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            FashUser user = (FashUser) auth.getPrincipal();

            user.setEmail(userUpdt.getEmail());
            user.setUsername(userUpdt.getUsername());
            user.setPassword(userUpdt.getPassword());

            userService.add(user);


            Client modelClient = clientService.getClientByUser((FashUser) auth.getPrincipal());
            model.addAttribute("user", user);
            model.addAttribute("client", modelClient);
            return "redirect:/u/account";
        }
        else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Client client = clientService.getClientByUser((FashUser) auth.getPrincipal());
            client.setAge(clientUpdt.getAge());
            client.setName(clientUpdt.getName());
            client.setLastName(clientUpdt.getLastName());

            clientService.add(client);

            FashUser user = (FashUser) auth.getPrincipal();
            model.addAttribute("user", user);
            model.addAttribute("client", client);

            return "redirect:/u/account";
        }
    }

}

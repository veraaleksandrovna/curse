package com.example.demo.api;

import com.example.demo.domain.Client;
import com.example.demo.domain.Deal;
import com.example.demo.domain.FashUser;
import com.example.demo.service.ClientService;
import com.example.demo.service.DealService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class MyOrdersController {

    private final ClientService clientService;
    private final UserService userService;
    private final DealService dealService;

    @GetMapping("/u/myOrders")
    public String orders(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        FashUser user = (FashUser) auth.getPrincipal();
        Client client = clientService.getClientByUser((FashUser) auth.getPrincipal());

        ArrayList<Deal> deals = dealService.findAllByClient(client);

        model.addAttribute("orders", deals);
        return "myOrders";
    }

    @PostMapping("/u/myOrders/delete")
    public String delete(@ModelAttribute("order") Deal deal)
    {
        dealService.delete(deal.getId());
        return "redirect:/u/myOrders";
    }

}

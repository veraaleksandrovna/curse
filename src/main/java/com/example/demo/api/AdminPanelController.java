package com.example.demo.api;

import com.example.demo.domain.Client;
import com.example.demo.domain.Deal;
import com.example.demo.domain.FashUser;
import com.example.demo.domain.roles.UserRole;
import com.example.demo.service.ClientService;
import com.example.demo.service.DealService;
import com.example.demo.service.PieceService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class AdminPanelController {
    private final ClientService clientService;
    private final PieceService pieceService;
    private final UserService userService;
    private final DealService dealService;

    @GetMapping("a/hello")
    String getPanel()
    {
        return "adminPanel";
    }
    @GetMapping("a/clients")
    String getClients(Model model)
    {
        ArrayList<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("changeClient", new Client());
        return "adminClients";
    }

    @PostMapping("a/clients/upd")
    String clientUpdate(@ModelAttribute("client") Client clientUpd){

        clientUpd.setUser(userService.findById(clientService.getUserId(clientUpd.getId())).get());
        clientService.add(clientUpd);
        return "redirect:/a/clients";
    }
    @PostMapping("a/clients/delete")
    String clientDelete(@ModelAttribute("client") Client clientUpd){
        clientService.delete(clientUpd.getId());
        return "redirect:/a/clients";
    }

    @GetMapping("a/users")
    String getUsers(Model model)
    {
        ArrayList<FashUser> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("changeUser", new FashUser());
        return "adminUsers";
    }

    @PostMapping("a/users/upd")
    String usersUpdate(@ModelAttribute("user") FashUser userUpd){
        userUpd.setRole(UserRole.USER);
        userService.add(userUpd);
        return "redirect:/a/users";
    }
    @PostMapping("a/users/delete")
    String usersDelete(@ModelAttribute("user") FashUser userUpd){
        userService.delete(userUpd.getId());
        return "redirect:/a/users";
    }
    @GetMapping("a/orders")
    String getOrders(Model model)
    {
        ArrayList<Deal> deals = dealService.findAll();
        model.addAttribute("orders", deals);
        model.addAttribute("changeOrder", new Deal());
        return "adminOrders";
    }

    @PostMapping("a/orders/upd")
    String ordersUpdate(@ModelAttribute("order") Deal dealUpd){
        dealService.save(dealUpd);
        return "redirect:/a/orders";
    }
    @PostMapping("a/orders/delete")
    String ordersDelete(@ModelAttribute("order") Deal dealUpd){
        dealService.delete(dealUpd.getId());
        return "redirect:/a/orders";
    }

}

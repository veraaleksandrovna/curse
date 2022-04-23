package com.example.demo.api;

import com.example.demo.domain.Client;
import com.example.demo.service.ClientService;
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

}

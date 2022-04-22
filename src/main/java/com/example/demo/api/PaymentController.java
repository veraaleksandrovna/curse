package com.example.demo.api;

import com.example.demo.domain.Client;
import com.example.demo.domain.Deal;
import com.example.demo.domain.FashUser;
import com.example.demo.domain.Piece;
import com.example.demo.service.ClientService;
import com.example.demo.service.DealService;
import com.example.demo.service.PieceService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Controller
@AllArgsConstructor
public class PaymentController {
    private final ClientService clientService;
    private final PieceService pieceService;
    private final DealService dealService;

    @GetMapping("/u/order")
    public String whichPage(@RequestParam("id") Long itemId, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(clientService.ifExists((FashUser) auth.getPrincipal()))
        {
            Piece item = pieceService.findById(itemId);
            String city = new String();
            String street = new String();
            String house = new String();
            String apt = new String();
            model.addAttribute("city", city);
            model.addAttribute("street", street);
            model.addAttribute("house", house);
            model.addAttribute("apt", apt);
            model.addAttribute("item", item);
            return "payment";
        } else
        {
            Client client = new Client();
            Piece item = pieceService.findById(itemId);
            model.addAttribute("item", item);
            model.addAttribute("clientt", client);
            return "submitPersonalData";
        }
    }

    @PostMapping("u/order/newCl")
    public String newClient(@RequestParam("id") Long itemId, @ModelAttribute("clientt") Client client, Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        client.setUser((FashUser) auth.getPrincipal());
        clientService.add(client);
        String city = new String();
        String street = new String();
        String house = new String();
        String apt = new String();
        model.addAttribute("city", city);
        model.addAttribute("street", street);
        model.addAttribute("house", house);
        model.addAttribute("apt", apt);
        model.addAttribute("clientt", client);
        model.addAttribute("item", pieceService.findById(itemId));
        return "payment";
    }

    @PostMapping("/u/order/success")
    public String success(
            @RequestParam("id") Long itemId,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "apt") String apt,
            @RequestParam(value = "house") String house,
            @RequestParam(value = "street") String street)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = clientService.getClientByUser((FashUser) auth.getPrincipal());
        Deal deal = new Deal();
        deal.setClient(client);
        LocalDate date = LocalDate.now();
        String dateStr = date.getDayOfMonth() + "." + date.getMonthValue() +"." + date.getYear();
        deal.setDate(dateStr);
        deal.setPiece(pieceService.findById(itemId));
        deal.setSum(pieceService.findById(itemId).getPrice());

        String address = city + " " + street + " " + house + " " + apt;
        System.out.println(address);
        deal.setAddress(address);

        dealService.save(deal);

        return "redirect:/u/hello";
    }
}

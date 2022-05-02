package com.example.demo.api;

import com.example.demo.domain.*;
import com.example.demo.domain.roles.UserRole;
import com.example.demo.service.*;
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
    private final TypeService typeService;
    private final CollectionService collectionService;
    private final SexService sexService;
    private final GiftCardService giftCardService;

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
    @GetMapping("a/goods")
    String getGoods()
    {
        return "adminGoods";
    }

    @GetMapping("a/goods/pieces")
    String getPieces(Model model)
    {
        ArrayList<Piece> pieces = pieceService.findAll();
        model.addAttribute("pieces", pieces);
        model.addAttribute("changePiece", new Piece());
        return "adminPieces";
    }

    @PostMapping("a/goods/pieces/upd")
    String piecesUpdate(@ModelAttribute("piece") Piece pieceUpd){
        Type type = typeService.fingByName(pieceUpd.getType().getName());
        pieceUpd.setType(type);
        Collection collection = collectionService.findByName(pieceUpd.getCollection().getName());
        pieceUpd.setCollection(collection);
        Sex sex = sexService.findByName(pieceUpd.getSex().getName());
        pieceUpd.setSex(sex);
        pieceService.save(pieceUpd);
        return "redirect:/a/goods/pieces";
    }
    @PostMapping("a/goods/pieces/delete")
    String piecesDelete(@ModelAttribute("piece") Piece pieceUpd){
        pieceService.delete(pieceUpd.getId());
        return "redirect:/a/goods/pieces";
    }
    @GetMapping("a/goods/types")
    String getTypes(Model model)
    {
        ArrayList<Type> types = typeService.findAll();
        ArrayList<Sex> sexes = sexService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("changeType", new Type());
        model.addAttribute("sexes", sexes);
        return "adminTypes";
    }

    @PostMapping("a/goods/types/add")
    String addType(@ModelAttribute("changeType") Type type){
        Sex sex = sexService.findByName(type.getSex().getName());
        type.setSex(sex);
        typeService.add(type);
        return "redirect:/a/goods/types";
    }
    @PostMapping("a/goods/types/delete")
    String deleteType(@ModelAttribute("type") Type type){
        typeService.delete(type.getId());
        return "redirect:/a/goods/types";
    }


    @GetMapping("a/goods/collections")
    String getCollections(Model model)
    {
        ArrayList<Collection> collections = collectionService.findAll();
        model.addAttribute("addCollection", new Collection());
        model.addAttribute("collections", collections);
        return "adminCollections";
    }

    @PostMapping("a/goods/collections/add")
    String addCollection(@ModelAttribute("addCollection") Collection collection){
    collectionService.add(collection);
    return "redirect:/a/goods/collections";
    }
    @PostMapping("a/goods/collections/delete")
    String deleteCollection(@ModelAttribute("collection") Collection collection){
        collectionService.delete(collection.getId());
        return "redirect:/a/goods/collections";
    }
    @GetMapping("a/gifts")
    String getGifts(Model model)
    {
        ArrayList<GiftCard> giftCards = giftCardService.findAll();
        model.addAttribute("addGiftCard", new GiftCard());
        model.addAttribute("giftCards", giftCards);
        return "adminGiftCards";
    }

    @PostMapping("a/gifts/add")
    String addGifts(@ModelAttribute("addGiftCard") GiftCard giftCard){
    giftCardService.add(giftCard);
    return "redirect:/a/gifts";
    }
    @PostMapping("a/gifts/delete")
    String deleteGifts(@ModelAttribute("giftcard") GiftCard giftCard){
    giftCardService.delete(giftCard.getId());
    return "redirect:/a/gifts";
    }
}

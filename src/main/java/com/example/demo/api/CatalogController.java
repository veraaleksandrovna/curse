//package com.example.demo.api;
//
//import com.example.demo.domain.Artcile;
//import com.example.demo.domain.GiftCard;
//import com.example.demo.domain.Piece;
//import com.example.demo.service.ArticleService;
//import com.example.demo.service.PieceService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.ArrayList;
//
//@Controller
//@AllArgsConstructor
//public class CatalogController {
//
//    private final PieceService pieceService;
//    private final ArticleService articleService;
//
//    @GetMapping("/u/articles")
//    public String articles(Model model){
//        ArrayList<Artcile> artciles = articleService.findAll();
//        model.addAttribute("articles", artciles);
//
//        return "articles";
//    }
//






























//
//
//
//    @GetMapping("/u/gifts")
//    public String gifts(Model model){
////        ArrayList<GiftCard> giftCards = pieceService.findAllBySection("Обувь");
////        model.addAttribute("shoes", shoes);
//        return "gifts";
//    }
//
//}

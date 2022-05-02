package com.example.demo.api;

import com.example.demo.domain.Artcile;
import com.example.demo.domain.FashUser;
import com.example.demo.domain.Piece;
import com.example.demo.service.ArticleService;
import com.example.demo.service.PieceService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainPageController {

    private final PieceService pieceService;
    private final ArticleService articleService;

    @GetMapping("/u/hello")
    public String hello(Model model, HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username","Hello " + auth.getName() + "!");
       /* ArrayList<Piece> bags = pieceService.findThreePieces("bags");
        ArrayList<Piece> sneakers = pieceService.findThreePieces("sneakers");
        ArrayList<Artcile> artciles = articleService.findThreeArticles();
        model.addAttribute("bag1", bags.get(0));
        model.addAttribute("bag2", bags.get(1));
        model.addAttribute("bag3", bags.get(2));

        model.addAttribute("sneakers1", sneakers.get(0));
        model.addAttribute("sneakers2", sneakers.get(1));
        model.addAttribute("sneakers3", sneakers.get(2));

        model.addAttribute("story1", artciles.get(0));
        model.addAttribute("story2", artciles.get(1));
        model.addAttribute("story3", artciles.get(2));
*/
        return "hello";
    }

}

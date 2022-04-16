package com.example.demo.api;

import com.example.demo.domain.Artcile;
import com.example.demo.domain.Piece;
import com.example.demo.service.ArticleService;
import com.example.demo.service.PieceService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class CatalogController {

    private final PieceService pieceService;
    private final ArticleService articleService;

    @GetMapping("/u/acs")
    public String hello(Model model){

        return "acs";
    }
}

package com.example.demo.api;

import com.example.demo.domain.Artcile;
import com.example.demo.domain.Sex;
import com.example.demo.domain.Type;
import com.example.demo.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class ArticleController {
    private final ArticleService service;

    @GetMapping("u/articles")
    String getArticles(Model model)
    {
        ArrayList<Artcile> artciles = service.findAll();
        model.addAttribute("articles", artciles);
        return "articles";
    }

    @GetMapping("u/articles/utyre")
    String getArticle(@RequestParam("id") Long id, Model model)
    {
        Artcile artcile = service.findById(id);
        model.addAttribute("article", artcile);
        return "article";
    }

}

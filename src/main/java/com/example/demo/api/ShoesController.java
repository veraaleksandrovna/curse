package com.example.demo.api;

import com.example.demo.domain.Piece;
import com.example.demo.service.PieceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class ShoesController {
    private final PieceService pieceService;

    @GetMapping("/u/shoes")
    public String shoes(Model model){

        ArrayList<Piece> shoes = pieceService.findAllBySection("Обувь");
        model.addAttribute("shoes", shoes);

        return "shoes";
    }

    @GetMapping("/u/shoes/buy")
    public String buy(@RequestParam("id") Long id, Model model)
    {
        Piece item = pieceService.findById(id);
        model.addAttribute("item", item);
        return "buyPage";
    }
}

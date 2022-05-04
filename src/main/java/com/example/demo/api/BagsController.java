package com.example.demo.api;

import com.example.demo.domain.Piece;
import com.example.demo.service.PieceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@AllArgsConstructor
public class BagsController {
    private final PieceService pieceService;

    @GetMapping("/u/bags")
    public String bags(Model model){
        ArrayList<Piece> bags = pieceService.findAllBySection("Сухие цветы");
        model.addAttribute("bags", bags);
        return "bags";
    }

    @GetMapping("/u/bags/buy")
    public String buy(@RequestParam("id") Long id, Model model)
    {
        Piece item = pieceService.findById(id);
        model.addAttribute("item", item);
        return "buyPage";
    }

}

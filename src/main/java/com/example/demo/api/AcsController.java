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

public class AcsController {

        private final PieceService pieceService;

    @GetMapping("/u/acs")
    public String acs(Model model){
        ArrayList<Piece> acs = pieceService.findAllBySection("Аксессуары");
        model.addAttribute("acs", acs);
        return "acs";
    }
    @GetMapping("/u/acs/buy")
    public String buy(@RequestParam("id") Long id, Model model)
    {
            Piece item = pieceService.findById(id);
            model.addAttribute("item", item);
            return "buyPage";
    }


}

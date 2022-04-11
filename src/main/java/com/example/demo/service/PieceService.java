package com.example.demo.service;

import com.example.demo.domain.Piece;
import com.example.demo.repos.PieceRepo;
import com.example.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PieceService {
    PieceRepo repo;

    @Autowired
    PieceService(PieceRepo repo){
        this.repo = repo;
    }

    public ArrayList<Piece> findThreePieces(String type){
        if(type.equals("bag"))
        {
            return repo.findThreeBags();
        }
        else if(type.equals("sneakers"))
        {
            return repo.findThreeSneakers();
        }
        else return null;
    }
}

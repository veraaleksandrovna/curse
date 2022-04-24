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
        if(type.equals("bags"))
        {
            return repo.findThreeBags();
        }
        else if(type.equals("sneakers"))
        {
            return repo.findThreeSneakers();
        }
        else return null;
    }

    public ArrayList<Piece> findAllBySection(String section){
        return repo.findAllByTypeSection(section);
    }
    public ArrayList<Piece> findAll(){
        return (ArrayList<Piece>) repo.findAll();
    }

    public Piece findById(Long id)
    {
        return repo.findPieceById(id);
    }

    public void save(Piece piece){
        repo.save(piece);
    }

    public void delete(Long id) {
        repo.delete(repo.findPieceById(id));
    }
}

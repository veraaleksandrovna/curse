package com.example.demo.service;

import com.example.demo.domain.Artcile;
import com.example.demo.domain.Piece;
import com.example.demo.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ArticleService {
    ArticleRepo repo;
    
    @Autowired
    ArticleService(ArticleRepo repo){
        this.repo=repo;
    }

    public ArrayList<Artcile> findThreeArticles(){
        return repo.findThreeArticles();
    }

    public ArrayList<Artcile> findAll(){
        return repo.findAll();
    }

    public Artcile findById(Long id) {
        return repo.findById(id).get();
    }
}

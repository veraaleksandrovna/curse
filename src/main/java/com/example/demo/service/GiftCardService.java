package com.example.demo.service;

import com.example.demo.domain.GiftCard;
import com.example.demo.repos.GiftCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GiftCardService {
    GiftCardRepo repo;

    @Autowired
    GiftCardService(GiftCardRepo repo){ this.repo=repo;}


    public ArrayList<GiftCard> findAll() {
        return (ArrayList<GiftCard>) repo.findAll();
    }
    public void add(GiftCard giftCard){
        repo.save(giftCard);
    }

    public void delete(Long id) {
        repo.delete(repo.getById(id));
    }
}

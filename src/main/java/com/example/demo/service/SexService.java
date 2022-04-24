package com.example.demo.service;

import com.example.demo.domain.Sex;
import com.example.demo.repos.SexRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SexService {
    SexRepo repo;

    @Autowired
    SexService(SexRepo repo){
        this.repo = repo;
    }

    public Sex findByName(String name){
        return repo.findByName(name);
    }

    public ArrayList<Sex> findAll(){
        return (ArrayList<Sex>) repo.findAll();
    }
}

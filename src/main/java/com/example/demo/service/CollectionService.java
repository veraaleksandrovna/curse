package com.example.demo.service;

import com.example.demo.domain.Collection;
import com.example.demo.repos.CollectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {
    CollectionRepo repo;

    @Autowired
    CollectionService(CollectionRepo repo){
        this.repo=repo;
    }

    public Collection findByName(String name){
        return repo.findByName(name);
    }
}

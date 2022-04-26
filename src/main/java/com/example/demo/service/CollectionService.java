package com.example.demo.service;

import com.example.demo.domain.Collection;
import com.example.demo.repos.CollectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    public ArrayList<Collection> findAll() {
        return (ArrayList<Collection>) repo.findAll();
    }

    public void add(Collection collection){
        repo.save(collection);
    }

    public void delete(Long id) {
        repo.delete(repo.getById(id));
    }
}

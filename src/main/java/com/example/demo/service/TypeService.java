package com.example.demo.service;

import com.example.demo.domain.Type;
import com.example.demo.repos.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TypeService {
    TypeRepo repo;
    @Autowired
    TypeService(TypeRepo repo){
        this.repo = repo;
    }

    public Type fingByName(String name){
        return repo.findByName(name);
    }

    public ArrayList<Type> findAll() {
        return (ArrayList<Type>) repo.findAll();
    }

    public void add(Type type) {
        repo.save(type);
    }

    public void delete(Long id)
    {
        repo.delete(repo.getById(id));
    }
}

package com.example.demo.service;

import com.example.demo.domain.Client;
import com.example.demo.domain.Deal;
import com.example.demo.repos.DealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DealService {
    DealRepo dealRepo;

    @Autowired
    DealService(DealRepo repo){this.dealRepo=repo;}

    public void save(Deal deal)
    {
        dealRepo.save(deal);
    }

    public ArrayList<Deal> findAll() {
        return (ArrayList<Deal>) dealRepo.findAll();
    }

    public void delete(Long id) {
        dealRepo.delete(dealRepo.getById(id));
    }

    public ArrayList<Deal> findAllByClient(Client client){
        return dealRepo.findAllByClient(client);
    }
}

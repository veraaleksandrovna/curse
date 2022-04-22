package com.example.demo.service;

import com.example.demo.domain.Deal;
import com.example.demo.repos.DealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealService {
    DealRepo dealRepo;

    @Autowired
    DealService(DealRepo repo){this.dealRepo=repo;}

    public void save(Deal deal)
    {
        dealRepo.save(deal);
    }
}

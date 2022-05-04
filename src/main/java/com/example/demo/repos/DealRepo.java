package com.example.demo.repos;

import com.example.demo.domain.Client;
import com.example.demo.domain.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DealRepo extends JpaRepository<Deal, Long> {
    ArrayList<Deal> findAllByClient(Client client);
}

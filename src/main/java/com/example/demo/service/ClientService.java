package com.example.demo.service;

import com.example.demo.domain.Client;
import com.example.demo.domain.FashUser;
import com.example.demo.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    ClientRepo repo;

    @Autowired
    ClientService(ClientRepo repo){ this.repo=repo;}

    public void add(Client client)
    {
        repo.save(client);
    }

    public boolean ifExists(FashUser user)
    {
        return repo.checkIfExists(user.getId()).isPresent();
    }

    public Client getClientByUser(FashUser user)
    {
        return repo.checkIfExists(user.getId()).get();
    }

}

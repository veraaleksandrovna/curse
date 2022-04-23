package com.example.demo.repos;

import com.example.demo.domain.Client;
import com.example.demo.domain.FashUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.fashUser.id=?1")
    Optional<Client> checkIfExists(Long id);

    @Query("select c from Client c where c.id=?1")
    Client getUserByClientId(Long id);
}

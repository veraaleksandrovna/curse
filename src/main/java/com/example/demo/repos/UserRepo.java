package com.example.demo.repos;

import com.example.demo.domain.FashUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<FashUser, Long> {


    @Query("select u from FashUser u where u.email=?1")
    Optional<FashUser> findUserByEmail(String email);
}

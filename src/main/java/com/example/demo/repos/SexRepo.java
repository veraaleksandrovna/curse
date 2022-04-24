package com.example.demo.repos;

import com.example.demo.domain.Sex;
import com.example.demo.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SexRepo extends JpaRepository<Sex, Long> {
    @Query("select s from Sex s where s.name=?1")
    Sex findByName(String name);
}

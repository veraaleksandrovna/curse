package com.example.demo.repos;

import com.example.demo.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type, Long> {
    @Query("select t from Type t where t.name=?1")
    Type findByName(String name);
}

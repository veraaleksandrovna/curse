package com.example.demo.repos;

import com.example.demo.domain.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepo extends JpaRepository<Collection, Long> {
    @Query("select c from Collection c where c.name=?1")
    Collection findByName(String name);
}

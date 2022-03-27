package com.example.demo.repos;

import com.example.demo.domain.Artcile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Artcile, Long> {
}
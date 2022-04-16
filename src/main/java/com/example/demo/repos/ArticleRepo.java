package com.example.demo.repos;

import com.example.demo.domain.Artcile;
import com.example.demo.domain.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ArticleRepo extends JpaRepository<Artcile, Long> {
    @Query("select a from Artcile a where a.id=?1")
    Optional<Piece> findArticleById(int id);

    @Query("select count (a) from Artcile a")
    int countArticleById();

    @Query("select a from Artcile a")
    ArrayList<Artcile> findThreeArticles();
}

package com.example.demo.repos;

import com.example.demo.domain.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PieceRepo extends JpaRepository<Piece, Long> {

    @Query("select p from Piece p where p.id=?1")
    Optional<Piece> findPieceById(int id);

    @Query("select count (p) from Piece p")
    int countPieceById();

    @Query("select p from Piece p, Type t where p.type = t and t.name='Рюкзаки'")
    ArrayList<Piece> findThreeBags();

    @Query("select p from Piece p, Type t where p.type = t and t.name='Кроссовки'")
    ArrayList<Piece> findThreeSneakers();

}

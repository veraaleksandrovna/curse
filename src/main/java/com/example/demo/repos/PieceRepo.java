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

    @Query("select 3 from Piece p where p.type='bag'")
    ArrayList<Piece> findThreeBags();

    @Query("select 3 from Piece p where p.type='sneakers'")
    ArrayList<Piece> findThreeSneakers();

}

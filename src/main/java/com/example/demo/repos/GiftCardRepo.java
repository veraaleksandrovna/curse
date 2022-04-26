package com.example.demo.repos;

import com.example.demo.domain.GiftCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftCardRepo extends JpaRepository<GiftCard, Long> {
}

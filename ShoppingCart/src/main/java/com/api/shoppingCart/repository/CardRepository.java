package com.api.shoppingCart.repository;

import com.api.shoppingCart.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, UUID> {

    public boolean existsByNumber(String number);
}

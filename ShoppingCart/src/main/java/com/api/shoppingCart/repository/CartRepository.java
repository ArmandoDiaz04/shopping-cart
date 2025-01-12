package com.api.shoppingCart.repository;

import com.api.shoppingCart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, UUID> {

    @Query("select c from CartEntity c join c.user u where u.userId = :customerId")
    Optional<CartEntity> findByCustomerId(@Param("customerId") UUID customerId);
}

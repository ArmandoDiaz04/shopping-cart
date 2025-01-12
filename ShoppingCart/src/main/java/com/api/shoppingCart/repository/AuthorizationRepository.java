package com.api.shoppingCart.repository;

import com.api.shoppingCart.entity.AuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorizationRepository extends JpaRepository<AuthorizationEntity, UUID> {

    @Query("select a from AuthorizationEntity a join a.orderEntity o where o.orderId = :id")
    AuthorizationEntity findByOrderId(@Param("id") UUID customerId);
}

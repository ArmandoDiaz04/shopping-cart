package com.api.shoppingCart.repository;

import com.api.shoppingCart.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    @Query("select o from OrderEntity o join o.userEntity u where u.userId = :customerId")
    Iterable<OrderEntity> findByCustomerId(@Param("customerId") UUID customerId);
}

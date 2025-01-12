package com.api.shoppingCart.repository;

import com.api.shoppingCart.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, UUID> {

    @Query(value = "select i.* from ecomm.cart c, ecomm.item i, ecomm.user u, ecomm.cart_item ci where u.user_id = :customerId and c.user_id=u.user_id and c.cart_id=ci.cart_id and i.item_id=ci.item_id", nativeQuery = true)
    Iterable<ItemEntity> findByCustomerId(UUID customerId);

    @Modifying
    @Query(value = "delete from ecomm.cart_item where item_id in (:ids) and cart_id = :cartId", nativeQuery = true)
    void deleteCartItemJoinById(List<Integer> ids, UUID cartId);
}

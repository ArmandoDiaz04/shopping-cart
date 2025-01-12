package com.api.shoppingCart.repository;

import com.api.shoppingCart.entity.UserTokenEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserTokenRepository extends CrudRepository<UserTokenEntity, UUID> {

    Optional<UserTokenEntity> findByRefreshToken(String refreshToken);

    @Modifying
    @Query(value = "delete from ecomm.user_token u where u.user_id = :userId", nativeQuery = true)
    public void deleteByUserId(UUID userId);
}

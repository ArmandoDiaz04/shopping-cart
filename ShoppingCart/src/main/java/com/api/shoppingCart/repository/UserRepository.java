package com.api.shoppingCart.repository;

import com.api.shoppingCart.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query(value = "select count(u.*) from ecomm.user u where u.username = :username or u.email = :email", nativeQuery = true)
    Integer findByUsernameOrEmail(String username, String email);
}
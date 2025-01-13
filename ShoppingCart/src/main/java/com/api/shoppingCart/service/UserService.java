package com.api.shoppingCart.service;

import com.api.shoppingCart.dto.RefreshTokenDTO;
import com.api.shoppingCart.dto.SignedInUserDTO;
import com.api.shoppingCart.dto.UserDTO;
import com.api.shoppingCart.entity.CardEntity;
import com.api.shoppingCart.entity.UserEntity;

import java.util.Optional;

public interface UserService {

    void deleteCustomerById(String id);

    Iterable<UserEntity> getAllCustomers();

    Optional<CardEntity> getCardByCustomerId(String id);

    Optional<UserEntity> getCustomerById(String id);

    Optional<SignedInUserDTO> createUser(UserDTO user);

    UserEntity findUserByUsername(String username);

    SignedInUserDTO getSignedInUser(UserEntity userEntity);

    Optional<SignedInUserDTO> getAccessToken(RefreshTokenDTO refreshToken);

    void removeRefreshToken(RefreshTokenDTO refreshToken);
}

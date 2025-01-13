package com.api.shoppingCart.service;

import com.api.shoppingCart.dto.AuthorizationDTO;
import  com.api.shoppingCart.entity.AuthorizationEntity;

import java.util.Optional;

public interface PaymentService {

    public Optional<AuthorizationEntity> addauthorization(AuthorizationDTO authorize);
}

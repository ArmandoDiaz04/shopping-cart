package com.api.shoppingCart.service;

import com.api.shoppingCart.dto.NewOrderDTO;
import com.api.shoppingCart.entity.OrderEntity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public interface OrderService {

    public Optional<OrderEntity> addOrder(@Valid NewOrderDTO newOrder);

    public Iterable<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId);

    public Optional<OrderEntity> getByOrderId(String id);
}
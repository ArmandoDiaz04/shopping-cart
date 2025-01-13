package com.api.shoppingCart.service;

import com.api.shoppingCart.dto.ItemDTO;
import com.api.shoppingCart.entity.CartEntity;
import jakarta.validation.Valid;

import java.util.List;

public interface CartService {

    public List<ItemDTO> addCartItemsByCustomerId(String customerId, @Valid ItemDTO item);

    public List<ItemDTO> addOrReplaceItemsByCustomerId(String customerId, @Valid ItemDTO item);

    public void deleteCart(String customerId);

    public void deleteItemFromCart(String customerId, Integer itemId);

    public CartEntity getCartByCustomerId(String customerId);

    public List<ItemDTO> getCartItemsByCustomerId(String customerId);

    public ItemDTO getCartItemsByItemId(String customerId, Integer itemId);
}

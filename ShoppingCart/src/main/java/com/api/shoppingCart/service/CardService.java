package com.api.shoppingCart.service;

import com.api.shoppingCart.dto.CardDTO;
import com.api.shoppingCart.entity.CardEntity;
import jakarta.validation.Valid;

import java.util.Optional;

public interface CardService {

    public void deleteCardById(String id);

    public Iterable<CardEntity> getAllCards();

    public Optional<CardEntity> getCardById(String id);

    public Optional<CardEntity> registerCard(@Valid CardDTO cardDTO);
}

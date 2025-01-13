package com.api.shoppingCart.controller;

import com.api.shoppingCart.apiInterface.CardApi;
import com.api.shoppingCart.dto.CardDTO;
import com.api.shoppingCart.hateoas.CardRepresentationModelAssembler;
import com.api.shoppingCart.service.CardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
public class CardRestController implements CardApi {

    private CardService service;
    private final CardRepresentationModelAssembler assembler;

    public CardRestController(CardService service, CardRepresentationModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<List<CardDTO>> getAllCards() {
        return ok(assembler.toListModel(service.getAllCards()));

    }

    @Override
    public ResponseEntity<Void> deleteCardById(String id) {
        this.service.deleteCardById(id);
        return accepted().build();
    }

    @Override
    public ResponseEntity<CardDTO> getCardById(String id) {
        return service.getCardById(id).map(assembler::toModel)
                .map(ResponseEntity::ok).get();
    }

    @Override
    public ResponseEntity<CardDTO> registerCard(@Valid CardDTO newCard) {
        return status(HttpStatus.CREATED).body(service.registerCard(newCard).map(assembler::toModel).get());
    }
}


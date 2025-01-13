package com.api.shoppingCart.serviceImplement;

import com.api.shoppingCart.dto.CardDTO;
import com.api.shoppingCart.entity.CardEntity;
import com.api.shoppingCart.entity.UserEntity;
import com.api.shoppingCart.exception.GenericAlreadyExistsException;
import com.api.shoppingCart.exception.ResourceNotFoundException;
import com.api.shoppingCart.repository.CardRepository;
import com.api.shoppingCart.repository.UserRepository;
import com.api.shoppingCart.service.CardService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository repository;
    private UserRepository userRepo;

    public CardServiceImpl(CardRepository repository, UserRepository userRepo) {
        this.repository = repository;
        this.userRepo = userRepo;
    }

    @Override
    public void deleteCardById(String id) {
        if (id == null || !repository.existsById(UUID.fromString(id))) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public Iterable<CardEntity> getAllCards() {
        return repository.findAll();
    }

    @Override
    public Optional<CardEntity> getCardById(String id) {
        if (id == null || !repository.existsById(UUID.fromString(id))) {
            throw new ResourceNotFoundException(String.format("Card with id %s not found:", id));
        }
        return repository.findById(UUID.fromString(id));
    }

    @Override
    public Optional<CardEntity> registerCard(@Valid CardDTO cardDTO) {
        if (repository.existsByNumber(cardDTO.getCardNumber())) {
            throw new GenericAlreadyExistsException(String.format("the card with number %s already exists", cardDTO.getCardNumber()));
        }
        return Optional.of(repository.save(toEntity(cardDTO)));
    }

    private CardEntity toEntity(CardDTO card) {
        CardEntity entity = new CardEntity();
        Optional<UserEntity> user = userRepo.findById(UUID.fromString(card.getUserId()));
        user.ifPresent(u -> entity.setUser(u));
        return entity.setNumber(card.getCardNumber()).setCvv(card.getCvv()).setExpires(card.getExpires());
    }
}


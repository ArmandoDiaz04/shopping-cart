package com.api.shoppingCart.serviceImplement;

import com.api.shoppingCart.dto.ItemDTO;
import com.api.shoppingCart.entity.CartEntity;
import com.api.shoppingCart.entity.ItemEntity;
import com.api.shoppingCart.exception.CustomerNotFoundException;
import com.api.shoppingCart.exception.GenericAlreadyExistsException;
import com.api.shoppingCart.exception.ItemNotFoundException;
import com.api.shoppingCart.exception.ResourceNotFoundException;
import com.api.shoppingCart.repository.CartRepository;
import com.api.shoppingCart.repository.UserRepository;
import com.api.shoppingCart.service.CartService;
import com.api.shoppingCart.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static org.springframework.objenesis.instantiator.util.UnsafeUtils.getUnsafe;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository repository;
    private UserRepository userRepo;
    private ItemService itemService;

    public CartServiceImpl(CartRepository repository, UserRepository userRepo, ItemService itemService) {
        this.repository = repository;
        this.userRepo = userRepo;
        this.itemService = itemService;
    }

    /**
     * si el item a persistir tiene el mismo id que uno de los productos de los item
     * del carrito se lanza la excepcion, sino se guarda.
     */
    @Override
    public List<ItemDTO> addCartItemsByCustomerId(String customerId, @Valid ItemDTO item) {
        CartEntity entity = getCartByCustomerId(customerId);
        long count = entity.getItems().stream()
                .filter(i -> i.getProduct().equals(item.getItemId())).count();
        if (count > 0) {
            throw new GenericAlreadyExistsException(
                    String.format("Item with Id (%s) already exists. You can update it.", item.getItemId()));
        }
        entity.getItems().add(itemService.toEntity(item));
        return itemService.toModelList(repository.save(entity).getItems());
    }

    @Override
    public List<ItemDTO> addOrReplaceItemsByCustomerId(String customerId, @Valid ItemDTO item) {
        CartEntity entity = getCartByCustomerId(customerId);
        List<ItemEntity> items = Objects.nonNull(entity.getItems()) ? entity.getItems() : Collections.emptyList();
        AtomicBoolean itemExists = new AtomicBoolean(false);
        items.forEach(i -> {
            if (i.getProduct().equals(item.getItemId())) {
                i.setQuantity(item.getQuantity()).setPrice(i.getPrice());
                itemExists.set(true);
            }
        });
        // * If not exist, added to cart
        if (!itemExists.get()) {
            items.add(itemService.toEntity(item));
        }
        return itemService.toModelList(repository.save(entity).getItems());
    }

    @Override
    public CartEntity getCartByCustomerId(String customerId) {
        CartEntity entity = repository.findByCustomerId(UUID.fromString(customerId))
                .orElse(new CartEntity());
        if (Objects.isNull(entity.getUser())) {
            entity.setUser(userRepo.findById(UUID.fromString(customerId))
                    .orElseThrow(() -> new CustomerNotFoundException(String.format(" - %s", customerId))));
        }
        return entity;
    }

    @Override
    public List<ItemDTO> getCartItemsByCustomerId(String customerId) {
        CartEntity entity = getCartByCustomerId(customerId);
        return itemService.toModelList(entity.getItems());
    }

    @Override
    public ItemDTO getCartItemsByItemId(String customerId, Integer itemId) {
        CartEntity entity = getCartByCustomerId(customerId);
        AtomicReference<ItemEntity> itemEntity = new AtomicReference<>();
        entity.getItems().forEach(i -> {
            if (i.getProduct().equals(itemId)) {
                itemEntity.set(i);
            }
        });
        if (Objects.isNull(itemEntity.get())) {
            // * with getUnsafe() we ​​don't need to catch or specify the exception in the
            // method declaration.
            getUnsafe().throwException(new ItemNotFoundException(String.format(" - %s", itemId)));
        }
        return itemService.toModel(itemEntity.get());
    }

    @Override
    public void deleteCart(String customerId) {
        CartEntity entity = getCartByCustomerId(customerId);
        if (entity.getCartId() == null) {
            getUnsafe().throwException(new ResourceNotFoundException(String.format(" - cart not found")));
        }
        repository.deleteById(entity.getCartId());

    }

    @Override
    public void deleteItemFromCart(String customerId, Integer itemId) {
        CartEntity entity = getCartByCustomerId(customerId);
        List<ItemEntity> updatedItems = entity.getItems().stream()
                .filter(i -> !i.getProduct().equals(itemId)).collect(Collectors.toList());
        entity.setItems(updatedItems);
        repository.save(entity);
    }
}


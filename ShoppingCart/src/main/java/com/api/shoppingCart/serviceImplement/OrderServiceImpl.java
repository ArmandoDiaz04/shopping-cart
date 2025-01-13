package com.api.shoppingCart.serviceImplement;

import com.api.shoppingCart.dto.*;
import com.api.shoppingCart.entity.*;
import com.api.shoppingCart.exception.ResourceNotFoundException;
import com.api.shoppingCart.repository.*;
import com.api.shoppingCart.service.OrderService;
import com.api.shoppingCart.util.StatusEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;
    private UserRepository userRepository;
    private ItemRepository itemRepository;
    private CartRepository cartRepository;
    private CardRepository cardRepository;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository repository, UserRepository userRepository, ItemRepository itemRepository,
                            CartRepository cartRepository, OrderItemRepository orderItemRepository, CardRepository cardRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
        this.orderItemRepository = orderItemRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public Optional<OrderEntity> addOrder(@Valid NewOrderDTO newOrder) {

        if (Strings.isEmpty(newOrder.getCustomerId())
                || !userRepository.existsById(UUID.fromString(newOrder.getCustomerId()))) {
            throw new ResourceNotFoundException("Invalid customer id.");
        }

        if (Objects.isNull(newOrder.getCardId()) || Strings.isEmpty(newOrder.getCardId()) || !cardRepository.existsById(UUID.fromString(newOrder.getCardId()))) {
            throw new ResourceNotFoundException("Invalid card id.");
        }
        // TODO: mmmm
        Iterable<ItemEntity> dbItems = itemRepository.findByCustomerId(UUID.fromString(newOrder.getCustomerId()));
        List<ItemEntity> items = StreamSupport.stream(dbItems.spliterator(), false).collect(Collectors.toList());
        if (items.size() < 1) {
            throw new ResourceNotFoundException(String
                    .format("There is no item found in customer's (ID: %s) cart.", newOrder.getCustomerId()));
        }
        BigDecimal total = BigDecimal.ZERO;
        for (ItemEntity i : items) {
            total = (BigDecimal.valueOf(i.getQuantity()).multiply(i.getPrice())).add(total);
        }
        Timestamp orderDate = Timestamp.from(Instant.now());

        OrderDTO order = new OrderDTO();
        order.card(new CardDTO(newOrder.getCardId())).customer(new UserDTO(newOrder.getCustomerId()))
                .date(orderDate).total(total).status(StatusEnum.CREATED).payment(new PaymentDTO().paymentId("0677d504-3862-4073-8cd1-5762f02c0288"));
        // Save Order
        OrderEntity entity = repository.save(toEntity(order));

        Optional<CartEntity> oCart = cartRepository.findByCustomerId(UUID.fromString(newOrder.getCustomerId()));
        CartEntity cart = oCart.orElseThrow(() -> new ResourceNotFoundException(
                String.format("Cart not found for given customer (ID: %s)", newOrder.getCustomerId())));
        itemRepository.deleteCartItemJoinById(
                cart.getItems().stream().map(i -> i.getItemId()).collect(Collectors.toList()), cart.getCartId());
        orderItemRepository.saveAll(cart.getItems().stream()
                .map(i -> new OrderItemEntity().setOrderId(entity.getOrderId()).setItemId(i.getItemId()))
                .collect(Collectors.toList()));
        return Optional.of(entity);
    }

    @Override
    public Iterable<OrderEntity> getOrdersByCustomerId(@NotNull @Valid String customerId) {
        return repository.findByCustomerId(UUID.fromString(customerId));
    }

    @Override
    public Optional<OrderEntity> getByOrderId(String id) {
        return repository.findById(UUID.fromString(id));
    }

    private OrderEntity toEntity(OrderDTO order) {
        OrderEntity entity = new OrderEntity();
        System.out.println(order.toString());
        entity.setCardEntity(new CardEntity(UUID.fromString(order.getCard().getCardId())))
                .setUserEntity(new UserEntity(UUID.fromString(order.getCustomer().getUserId())))
                .setOrderDate(order.getDate()).setTotal(order.getTotal()).setStatus(order.getStatus());
        return entity;
    }

}

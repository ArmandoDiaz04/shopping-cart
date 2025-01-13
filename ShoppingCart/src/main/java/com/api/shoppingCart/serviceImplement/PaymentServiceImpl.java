package com.api.shoppingCart.serviceImplement;

import com.api.shoppingCart.dto.AuthorizationDTO;
import com.api.shoppingCart.entity.AuthorizationEntity;
import com.api.shoppingCart.entity.OrderEntity;
import com.api.shoppingCart.exception.GenericAlreadyExistsException;
import com.api.shoppingCart.exception.ResourceNotFoundException;
import com.api.shoppingCart.repository.AuthorizationRepository;
import com.api.shoppingCart.repository.OrderRepository;
import com.api.shoppingCart.service.PaymentService;
import com.api.shoppingCart.util.StatusEnum;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final AuthorizationRepository authorizationRepository;

    private final OrderRepository orderRepository;

    public PaymentServiceImpl(AuthorizationRepository authorizationRepository, OrderRepository orderRepository) {
        this.authorizationRepository = authorizationRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<AuthorizationEntity> addauthorization(AuthorizationDTO authorize) {

        if (authorizationRepository.findByOrderId(UUID.fromString(authorize.getOrderId())) != null) {
            throw new GenericAlreadyExistsException("the order already has an authorization");
        }
        OrderEntity order = orderRepository.findById(UUID.fromString(authorize.getOrderId())).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        if (!Strings.isBlank(authorize.getError())) {
            order.setStatus(StatusEnum.PAYMENT_FAILED);
        }else if(authorize.getAuthorized()){
            order.setStatus(StatusEnum.PAID);
        }
        return Optional.of(authorizationRepository.save(toEntity(authorize).setOrderEntity(order)));

    }

    private AuthorizationEntity toEntity(AuthorizationDTO auth) {
        AuthorizationEntity entity = new AuthorizationEntity();
        Optional<OrderEntity> order = orderRepository.findById(UUID.fromString(auth.getOrderId()));
        order.ifPresent(o -> entity.setOrderEntity(o));
        return entity.setAuthorized(auth.getAuthorized()).setTime(auth.getTime()).setMessage(auth.getMessage())
                .setError(auth.getError());
    }

}

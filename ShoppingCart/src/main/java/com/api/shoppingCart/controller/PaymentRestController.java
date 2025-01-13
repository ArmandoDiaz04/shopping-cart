package com.api.shoppingCart.controller;

import com.api.shoppingCart.apiInterface.PaymentApi;
import com.api.shoppingCart.dto.AuthorizationDTO;
import com.api.shoppingCart.hateoas.PaymentRepresentationModelAssembler;
import com.api.shoppingCart.service.PaymentService;
import io.swagger.annotations.Authorization;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class PaymentRestController implements PaymentApi {

    private final PaymentService paymentService;
    private final PaymentRepresentationModelAssembler assembler;

    public PaymentRestController(PaymentService paymentService, PaymentRepresentationModelAssembler assembler) {
        this.paymentService = paymentService;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<Authorization> getOrdersPaymentAuthorization(@NotNull @Valid String orderId) {
        // TODO Auto-generated method stub
        return PaymentApi.super.getOrdersPaymentAuthorization(orderId);
    }

    @Override
    public ResponseEntity<AuthorizationDTO> authorize(@Valid AuthorizationDTO authPayment) {
        return ok(this.assembler.toModel(paymentService.addauthorization(authPayment).get()));
    }

}

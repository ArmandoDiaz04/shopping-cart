package com.api.shoppingCart.entity;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue
    @Column(name = "payment_id", updatable = false, nullable = false)
    private UUID paymentId;

    @Column(name="authorized")
    private boolean authorized;

    @Column(name = "message")
    private String message;

    @OneToOne(mappedBy = "paymentEntity")
    private OrderEntity orderEntity;

    public UUID getPaymentId() {
        return paymentId;
    }

    public PaymentEntity setId(UUID id) {
        this.paymentId = id;
        return this;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public PaymentEntity setAuthorized(boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public PaymentEntity setMessage(String message) {
        this.message = message;
        return this;
    }

}

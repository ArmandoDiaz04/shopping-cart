package com.api.shoppingCart.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;



@Entity
@Table(name = "authorization")
public class AuthorizationEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "authorized")
    private boolean authorized;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "message")
    private String message;

    @Column(name = "error")
    private String error;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private OrderEntity orderEntity;

    public UUID getId() {
        return id;
    }

    public AuthorizationEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public AuthorizationEntity setAuthorized(boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    public Timestamp getTime() {
        return time;
    }

    public AuthorizationEntity setTime(Timestamp time) {
        this.time = time;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AuthorizationEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getError() {
        return error;
    }

    public AuthorizationEntity setError(String error) {
        this.error = error;
        return this;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public AuthorizationEntity setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
        return this;
    }

}

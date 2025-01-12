package com.api.shoppingCart.entity;

import com.api.shoppingCart.util.StatusEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id", updatable = false, nullable = false)
    private UUID orderId;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private UserEntity userEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private PaymentEntity paymentEntity;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    private CardEntity cardEntity;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "order_item", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemEntity> items = Collections.emptyList();

    @OneToOne(mappedBy = "orderEntity")
    private AuthorizationEntity authorizationEntity;

    public UUID getOrderId() {
        return this.orderId;
    }

    public OrderEntity setOrderId(UUID id) {
        this.orderId = id;
        return this;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public OrderEntity setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public StatusEnum getStatus() {
        return this.status;
    }

    public OrderEntity setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public OrderEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public PaymentEntity getPaymentEntity() {
        return this.paymentEntity;
    }

    public OrderEntity setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
        return this;
    }

    public CardEntity getCardEntity() {
        return this.cardEntity;
    }

    public OrderEntity setCardEntity(CardEntity cardEntity) {
        this.cardEntity = cardEntity;
        return this;
    }

    public Timestamp getOrderDate() {
        return this.orderDate;
    }

    public OrderEntity setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public List<ItemEntity> getItems() {
        return this.items;
    }

    public OrderEntity setItems(List<ItemEntity> items) {
        this.items = items;
        return this;
    }

    public AuthorizationEntity getAuthorizationEntity() {
        return authorizationEntity;
    }

    public OrderEntity setAuthorizationEntity(
            AuthorizationEntity authorizationEntity) {
        this.authorizationEntity = authorizationEntity;
        return this;
    }

}

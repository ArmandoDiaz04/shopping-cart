package com.api.shoppingCart.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "card")
@NoArgsConstructor
public class CardEntity {

    @Id
    @GeneratedValue
    @Column(name = "card_id", updatable = false, nullable = false)
    private UUID cardId;

    @Column(name = "number")
    private String number;

    @Column(name = "expires")
    private String expires;

    @Column(name = "cvv")
    private String cvv;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "cardEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderEntity> orders;

    public CardEntity(UUID cardId) {
        this.cardId = cardId;
    }

    public UUID getCardId() {
        return cardId;
    }

    public CardEntity setCardId(UUID cardId) {
        this.cardId = cardId;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public CardEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getExpires() {
        return expires;
    }

    public CardEntity setExpires(String expires) {
        this.expires = expires;
        return this;
    }

    public String getCvv() {
        return cvv;
    }

    public CardEntity setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public CardEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public List<OrderEntity> getOrderEntity() {
        return orders;
    }

    public CardEntity setOrderEntity(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }
}
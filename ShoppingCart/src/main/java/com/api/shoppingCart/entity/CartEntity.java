package com.api.shoppingCart.entity;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cart")
public class CartEntity {

    @Id
    @GeneratedValue
    @Column(name = "cart_id", updatable = false, nullable = false)
    private UUID cartId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_item", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemEntity> items = Collections.emptyList();

    public UUID getCartId() {
        return cartId;
    }

    public CartEntity setCartId(UUID id) {
        this.cartId = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public CartEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public CartEntity setItems(List<ItemEntity> items) {
        this.items = items;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartEntity that = (CartEntity) o;
        return user.equals(that.user) && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, items);
    }

}

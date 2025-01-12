package com.api.shoppingCart.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", updatable = false, nullable = false)
    private Integer itemId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "unit_price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<CartEntity> cart;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<OrderEntity> orders;

    public Integer getItemId() {
        return itemId;
    }

    public ItemEntity setItemId(Integer itemId) {
        this.itemId = itemId;
        return this;
    }

    public Integer getProduct() {
        return this.productId;
    }

    public ItemEntity setProduct(Integer productId) {
        this.productId = productId;
        return this;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public ItemEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemEntity setQuantity(int quantity) {
        this.quantity = quantity;
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
        ItemEntity that = (ItemEntity) o;
        return quantity == that.quantity && productId.equals(that.productId) && Objects
                .equals(price, that.price);// && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price, quantity);// , cart);
    }

    public List<CartEntity> getCart() {
        return cart;
    }

    public ItemEntity setCart(List<CartEntity> cart) {
        this.cart = cart;
        return this;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public ItemEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }
}

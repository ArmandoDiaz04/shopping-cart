package com.api.shoppingCart.entity;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "item_id")
    private Integer itemId;

    public UUID getId() {
        return id;
    }

    public OrderItemEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderItemEntity setOrderId(UUID orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getItemId() {
        return itemId;
    }

    public OrderItemEntity setItemId(Integer itemId) {
        this.itemId = itemId;
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
        OrderItemEntity that = (OrderItemEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(orderId, that.orderId)
                && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, itemId);
    }

    @Override
    public String toString() {
        return "OrderItemEntity{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                '}';
    }
}

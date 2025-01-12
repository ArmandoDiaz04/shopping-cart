package com.api.shoppingCart.dto;

import com.api.shoppingCart.util.StatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@ApiModel(description = "Represents an order")
public class OrderDTO extends RepresentationModel<OrderDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("customer")
    private UserDTO customer;

    @JsonProperty("card")
    private CardDTO card;

    @JsonProperty("date")
    private Timestamp date;

    @JsonProperty("items")
    @Valid
    private List<ItemDTO> items = null;

    @JsonProperty("total")
    private BigDecimal total = null;

    @JsonProperty("payment")
    private PaymentDTO payment;

    @JsonProperty("status")
    private StatusEnum status;

    /**
     * Order identifier
     *
     * @return orderId
     */
    @ApiModelProperty(value = "Order identifier")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderDTO orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * customer related to the order
     *
     * @return customer
     */
    @ApiModelProperty(value = "customer related to the order")
    @Valid
    public UserDTO getCustomer() {
        return customer;
    }

    public void setCustomer(UserDTO customer) {
        this.customer = customer;

    }

    public OrderDTO customer(UserDTO customer) {
        this.customer = customer;
        return this;
    }

    /**
     * customer card related to the order
     *
     * @return card
     */
    @ApiModelProperty(value = "Customer card related to the order")
    @Valid
    public CardDTO getCard() {
        return card;
    }

    public void setCard(CardDTO card) {
        this.card = card;
    }

    public OrderDTO card(CardDTO card) {
        this.card = card;
        return this;
    }

    /**
     * Order's data and time details
     *
     * @return date
     */
    @ApiModelProperty(value = "Order's data and time details")
    @Valid
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public OrderDTO date(Timestamp date) {
        this.date = date;
        return this;
    }

    /**
     * Collection of order items.
     *
     * @return items
     */
    @ApiModelProperty(value = "Collection of order items.")
    @Valid
    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public OrderDTO items(List<ItemDTO> items) {
        this.items = items;
        return this;
    }

    public OrderDTO addItems(ItemDTO items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(items);
        return this;
    }

    /**
     * Order total
     *
     * @return total
     */
    @ApiModelProperty(value = "Order total")
    @Valid
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderDTO total(BigDecimal total) {
        this.total = total;
        return this;
    }

    /**
     * Get payment
     *
     * @return payment
     */
    @ApiModelProperty(value = "Order payment")
    @Valid
    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public OrderDTO payment(PaymentDTO payment) {
        this.payment = payment;
        return this;
    }

    /**
     * Order Status
     *
     * @return status
     */
    @ApiModelProperty(value = "Order Status")
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public OrderDTO status(StatusEnum status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderDTO order = (OrderDTO) o;
        return Objects.equals(this.orderId, order.orderId) &&
                Objects.equals(this.customer, order.customer) &&
                Objects.equals(this.card, order.card) &&
                Objects.equals(this.date, order.date) &&
                Objects.equals(this.items, order.items) &&
                Objects.equals(this.total, order.total) &&
                Objects.equals(this.payment, order.payment) &&
                Objects.equals(this.status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, card, date, items, total, payment, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Order {\n");
        sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

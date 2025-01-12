package com.api.shoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@NoArgsConstructor
@ApiModel(description = "Contains the payment request information")
public class PaymentDetailDTO extends RepresentationModel<PaymentDetailDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("customer")
    private CustomerInfoOnCardDTO customer;

    @JsonProperty("card")
    private CardDTO card;

    @JsonProperty("amount")
    private BigDecimal amount = null;


    /**
     * Order Identifier
     *
     * @return orderId
     */
    @ApiModelProperty(value = "Identifier")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PaymentDetailDTO id(String orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * Get customer
     *
     * @return customer
     */
    @ApiModelProperty(value = "Customer")
    @Valid
    public CustomerInfoOnCardDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfoOnCardDTO customer) {
        this.customer = customer;
    }

    public PaymentDetailDTO customer(CustomerInfoOnCardDTO customer) {
        this.customer = customer;
        return this;
    }


    /**
     * Get card
     *
     * @return card
     */
    @ApiModelProperty(value = "Payment card")
    @Valid
    public CardDTO getCard() {
        return card;
    }

    public void setCard(CardDTO card) {
        this.card = card;
    }

    public PaymentDetailDTO card(CardDTO card) {
        this.card = card;
        return this;
    }


    /**
     * Payment amount
     *
     * @return amount
     */
    @ApiModelProperty(value = "Payment amount")
    @Valid
    public java.math.BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentDetailDTO amount(java.math.BigDecimal amount) {
        this.amount = amount;
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
        PaymentDetailDTO paymentDetailDTO = (PaymentDetailDTO) o;
        return Objects.equals(this.orderId, paymentDetailDTO.orderId) &&
                Objects.equals(this.customer, paymentDetailDTO.customer) &&
                Objects.equals(this.card, paymentDetailDTO.card) &&
                Objects.equals(this.amount, paymentDetailDTO.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, card, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentReq {\n");

        sb.append("    id: ").append(toIndentedString(orderId)).append("\n");
        sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

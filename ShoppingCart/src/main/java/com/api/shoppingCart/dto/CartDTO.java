package com.api.shoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@ApiModel(description = "Shopping Cart of the user")
public class CartDTO extends RepresentationModel<CardDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("cartId")
    private String cardId;

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("items")
    @Valid
    private List<ItemDTO> items = null;


    /**
     * Cart Identifier
     *
     * @return id
     */
    @ApiModelProperty(value = "Cart Identifier")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public CartDTO cardId(String cardId) {
        this.cardId = cardId;
        return this;
    }


    /**
     * Id of the customer who possesses the cart
     *
     * @return customerId
     */
    @ApiModelProperty(value = "Id of the customer who possesses the cart")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CartDTO customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }


    /**
     * Collection of items in cart.
     *
     * @return items
     */
    @ApiModelProperty(value = "Collection of items in cart.")
    @Valid
    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public CartDTO items(List<ItemDTO> items) {
        this.items = items;
        return this;
    }

    public CartDTO addItems(ItemDTO items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(items);
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
        CartDTO cartDTO = (CartDTO) o;
        return Objects.equals(this.cardId, cartDTO.cardId) &&
                Objects.equals(this.customerId, cartDTO.customerId) &&
                Objects.equals(this.items, cartDTO.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, customerId, items);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Cart {\n");
        sb.append("    cartId: ").append(toIndentedString(cardId)).append("\n");
        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
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


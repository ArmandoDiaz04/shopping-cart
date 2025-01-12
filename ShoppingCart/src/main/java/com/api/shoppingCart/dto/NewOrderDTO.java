package com.api.shoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@ApiModel(description = "Contains the new order request information")
public class NewOrderDTO extends RepresentationModel<NewOrderDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("card")
    private String cardId;

    /**
     * Get customerId
     *
     * @return customerId
     */
    @ApiModelProperty(value = "Customer Identifier")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public NewOrderDTO customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }


    /**
     * Get card
     *
     * @return card
     */
    @ApiModelProperty(value = "Customer card")
    @Valid
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String card) {
        this.cardId = card;
    }

    public NewOrderDTO cardId(String card) {
        this.cardId = card;
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
        NewOrderDTO newOrder = (NewOrderDTO) o;
        return Objects.equals(this.customerId, newOrder.customerId) &&
                Objects.equals(this.cardId, newOrder.cardId);
    }
}


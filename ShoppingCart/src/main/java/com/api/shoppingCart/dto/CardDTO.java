package com.api.shoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@ApiModel(description = "Represents a user card")
public class CardDTO extends RepresentationModel<CardDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("cardId")
    private String cardId;

    @JsonProperty("cardNumber")
    private String cardNumber;

    @JsonProperty("expires")
    private String expires;

    @JsonProperty("cvv")
    private String cvv;

    @JsonProperty("userId")
    private String userId;

    public CardDTO(String cardId) {
        this.cardId = cardId;
    }

    /**
     * Card identifier
     *
     * @return id
     */
    @ApiModelProperty(value = "Card identifier")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public CardDTO cardId(String id) {
        this.cardId = id;
        return this;
    }

    /**
     * Card Number
     *
     * @return cardNumber
     */
    @ApiModelProperty(value = "Card Number")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardDTO cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    /**
     * Expiration date
     *
     * @return expires
     */
    @ApiModelProperty(value = "Expiration date")
    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public CardDTO expires(String expires) {
        this.expires = expires;
        return this;
    }

    /**
     * CVV code
     *
     * @return cvv
     */
    @ApiModelProperty(value = "CVV code")
    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public CardDTO cvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    /**
     * Get userId
     *
     * @return userId
     */
    @ApiModelProperty(value = "card user identifier")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CardDTO userId(String userId) {
        this.userId = userId;
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
        CardDTO cardDTO = (CardDTO) o;
        return Objects.equals(this.cardId, cardDTO.cardId) &&
                Objects.equals(this.cardNumber, cardDTO.cardNumber) &&
                Objects.equals(this.expires, cardDTO.expires) &&
                Objects.equals(this.cvv, cardDTO.cvv) &&
                Objects.equals(this.userId, cardDTO.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardNumber, expires, cvv, userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AddCardReq {\n");

        sb.append("    CardId: ").append(toIndentedString(cardId)).append("\n");
        sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
        sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
        sb.append("    cvv: ").append(toIndentedString(cvv)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

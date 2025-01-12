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
@ApiModel(description = "Represents a Payment")
public class PaymentDTO extends RepresentationModel<PaymentDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("paymentId")
    private String paymentId;

    @JsonProperty("authorized")
    private Boolean authorized;

    @JsonProperty("message")
    private String message;


    /**
     * Order identifier
     *
     * @return id
     */
    @ApiModelProperty(value = "Payment identifier")
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentDTO paymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    /**
     * Flag that specified whether payment is authorized or not
     *
     * @return authorized
     */
    @ApiModelProperty(value = "Flag that specified whether payment is authorized or not")
    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public PaymentDTO authorized(Boolean authorized) {
        this.authorized = authorized;
        return this;
    }

    /**
     * Approval or rejection message
     *
     * @return message
     */
    @ApiModelProperty(value = "Approval or rejection message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PaymentDTO message(String message) {
        this.message = message;
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
        PaymentDTO paymentDTO = (PaymentDTO) o;
        return Objects.equals(this.paymentId, paymentDTO.paymentId) &&
                Objects.equals(this.authorized, paymentDTO.authorized) &&
                Objects.equals(this.message, paymentDTO.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, authorized, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Payment {\n");

        sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
        sb.append("    authorized: ").append(toIndentedString(authorized)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

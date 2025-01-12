package com.api.shoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.lang.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@NoArgsConstructor
@ApiModel(description = "Request object for a new Authorization.")
public class AuthorizationDTO extends RepresentationModel<AuthorizationDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("time")
    private Timestamp time;

    @JsonProperty("authorized")
    private Boolean authorized;

    @JsonProperty("message")
    private String message;

    @JsonProperty("error")
    private String error;


    @ApiModelProperty(value = "Order Identification")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public AuthorizationDTO orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * Authorization Identification
     *
     * @return orderId
     */
    @ApiModelProperty(value = "Authorization Identification")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AuthorizationDTO id(String id) {
        this.id = id;
        return this;
    }


    /**
     * Timestamp when this authorization was created
     *
     * @return time
     */
    @ApiModelProperty(value = "Timestamp when this authorization was created")
    @Valid
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public AuthorizationDTO time(Timestamp time) {
        this.time = time;
        return this;
    }



    /**
     * Boolean specifying if the payment is authorized
     *
     * @return authorized
     */
    @ApiModelProperty(value = "Boolean specifying if the payment is authorized")
    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public AuthorizationDTO authorized(Boolean authorized) {
        this.authorized = authorized;
        return this;
    }


    /**
     * Message detailing approval or rejection
     *
     * @return message
     */
    @ApiModelProperty(value = "Message detailing approval or rejection")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthorizationDTO message(String message) {
        this.message = message;
        return this;
    }


    /**
     * Processing error description, if any
     *
     * @return error
     */
    @ApiModelProperty(value = "Processing error description, if any")
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public AuthorizationDTO error(String error) {
        this.error = error;
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
        AuthorizationDTO authorizationDTO = (AuthorizationDTO) o;
        return Objects.equals(this.id, authorizationDTO.id) &&
                Objects.equals(this.time, authorizationDTO.time) &&
                Objects.equals(this.authorized, authorizationDTO.authorized) &&
                Objects.equals(this.message, authorizationDTO.message) &&
                Objects.equals(this.error, authorizationDTO.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, authorized, message, error);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Authorization {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
        sb.append("    authorized: ").append(toIndentedString(authorized)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

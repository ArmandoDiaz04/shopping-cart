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
@ApiModel(description = "User or customer information")
public class UserDTO extends RepresentationModel<UserDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("userStatus")
    private String userStatus;

    @JsonProperty("cardId")
    private String cardId;

    public UserDTO(String userId) {
        this.userId = userId;
    }

    /**
     * Get id
     *
     * @return id
     */
    @ApiModelProperty(value = "User identifier")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDTO userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get username
     *
     * @return username
     */
    @ApiModelProperty(value = "Customer username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDTO username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Get firstName
     *
     * @return firstName
     */
    @ApiModelProperty(value = "Customer first")

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserDTO firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get lastName
     *
     * @return lastName
     */
    @ApiModelProperty(value = "customer's last name")

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserDTO lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     */
    @ApiModelProperty(value = "Customer email")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDTO email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get password
     *
     * @return password
     */
    @ApiModelProperty(value = "Customer Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get phone
     *
     * @return phone
     */
    @ApiModelProperty(value = "Customer phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserDTO phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get userStatus
     *
     * @return userStatus
     */
    @ApiModelProperty(value = "variable indicating the state of the client")
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public UserDTO userStatus(String userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    /**
     * Get cardId
     *
     * @return cardId
     */
    @ApiModelProperty(value = "Customer card identifier")

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public UserDTO cardId(String cardId) {
        this.cardId = cardId;
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
        UserDTO user = (UserDTO) o;
        return Objects.equals(this.userId, user.userId) &&
                Objects.equals(this.username, user.username) &&
                Objects.equals(this.firstName, user.firstName) &&
                Objects.equals(this.lastName, user.lastName) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.password, user.password) &&
                Objects.equals(this.phone, user.phone) &&
                Objects.equals(this.userStatus, user.userStatus) &&
                Objects.equals(this.cardId, user.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, firstName, lastName, email, password, phone, userStatus, cardId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");

        sb.append("    id: ").append(toIndentedString(userId)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
        sb.append("    cardId: ").append(toIndentedString(cardId)).append("\n");
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


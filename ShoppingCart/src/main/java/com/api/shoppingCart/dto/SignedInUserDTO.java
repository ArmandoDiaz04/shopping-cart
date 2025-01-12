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
@ApiModel(description = "Signed-in user information")
public class SignedInUserDTO extends RepresentationModel<SignedInUserDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("refreshToken")
    private String refreshToken;

    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("username")
    private String username;

    @JsonProperty("userId")
    private String userId;

    /**
     * Refresh Token
     *
     * @return refreshToken
     */
    @ApiModelProperty(value = "Refresh Token")
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public SignedInUserDTO refreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    /**
     * JWT Token aka access token
     *
     * @return accessToken
     */
    @ApiModelProperty(value = "JWT Token aka access token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public SignedInUserDTO accessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    /**
     * User Name
     *
     * @return username
     */
    @ApiModelProperty(value = "User Name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SignedInUserDTO username(String username) {
        this.username = username;
        return this;
    }

    /**
     * User Identifier
     *
     * @return userId
     */
    @ApiModelProperty(value = "User Identifier")

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SignedInUserDTO userId(String userId) {
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
        SignedInUserDTO signedInUser = (SignedInUserDTO) o;
        return Objects.equals(this.refreshToken, signedInUser.refreshToken) &&
                Objects.equals(this.accessToken, signedInUser.accessToken) &&
                Objects.equals(this.username, signedInUser.username) &&
                Objects.equals(this.userId, signedInUser.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refreshToken, accessToken, username, userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SignedInUser {\n");

        sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
        sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

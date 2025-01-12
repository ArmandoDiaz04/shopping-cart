package com.api.shoppingCart.entity;

import java.util.UUID;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_token")
public class UserTokenEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull(message = "Refresh token is required.")
    @Basic(optional = false)
    @Column(name = "refresh_token")
    private String refreshToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public UUID getId() {
        return id;
    }

    public UserTokenEntity setId(UUID id, UserEntity user, String refreshToken) {
        this.id = id;
        this.refreshToken = refreshToken;
        this.user = user;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public UserTokenEntity setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public UserTokenEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}

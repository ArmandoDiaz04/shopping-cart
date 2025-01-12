package com.api.shoppingCart.entity;

import com.api.shoppingCart.util.RoleEnum;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;

    @NotNull(message = "User name is required.")
    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "user_status")
    private String userStatus = "ACTIVE";

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private RoleEnum role = RoleEnum.USER;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CardEntity> cards;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private CartEntity cart;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderEntity> orders;

    public UserEntity(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UserEntity setUserId(UUID id) {
        this.userId = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public UserEntity setUserStatus(String userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public List<CardEntity> getCard() {
        return cards;
    }

    public UserEntity setCard(List<CardEntity> card) {
        this.cards = card;
        return this;
    }

    public CartEntity getCart() {
        return cart;
    }

    public UserEntity setCart(CartEntity cart) {
        this.cart = cart;
        return this;
    }

    public List<OrderEntity> getOrder() {
        return orders;
    }

    public UserEntity setOrder(List<OrderEntity> order) {
        this.orders = order;
        return this;
    }

    public RoleEnum getRole() {
        return role;
    }

    public UserEntity setRole(RoleEnum role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", role=" + role +
                ", cards=" + cards +
                ", cart=" + cart +
                ", orders=" + orders +
                '}';
    }
}
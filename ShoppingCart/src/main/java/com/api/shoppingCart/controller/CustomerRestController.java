package com.api.shoppingCart.controller;

import com.api.shoppingCart.apiInterface.CustomerApi;
import com.api.shoppingCart.dto.CardDTO;
import com.api.shoppingCart.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController implements CustomerApi {

    @Override
    public ResponseEntity<List<UserDTO>> getAllCustomers() {
        // TODO Auto-generated method stub
        return CustomerApi.super.getAllCustomers();
    }

    @Override
    public ResponseEntity<UserDTO> getCustomerById(String id) {
        // TODO Auto-generated method stub
        return CustomerApi.super.getCustomerById(id);
    }

    @Override
    public ResponseEntity<Void> deleteCustomerById(String id) {
        // TODO Auto-generated method stub
        return CustomerApi.super.deleteCustomerById(id);
    }

    @Override
    public ResponseEntity<CardDTO> getCardByCustomerId(String cardId) {
        // TODO Auto-generated method stub
        return CustomerApi.super.getCardByCustomerId(cardId);
    }


}


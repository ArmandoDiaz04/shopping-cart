package com.api.shoppingCart.controller;

import com.api.shoppingCart.apiInterface.ProductApi;
import com.api.shoppingCart.dto.ProductDTO;
import com.api.shoppingCart.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ProductRestController implements ProductApi {

    private ProductService service;

    public ProductRestController(ProductService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<ProductDTO> getProduct(Integer id) {
        return ok(this.service.getASingleProduct(id));
    }

    @Override
    public ResponseEntity<List<ProductDTO>> queryProducts() {
        return ok(this.service.getAllProducts());
    }

}


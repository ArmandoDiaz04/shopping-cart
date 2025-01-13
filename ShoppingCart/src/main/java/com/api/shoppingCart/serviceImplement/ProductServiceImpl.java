package com.api.shoppingCart.serviceImplement;

import com.api.shoppingCart.clients.ProductServiceClient;
import com.api.shoppingCart.dto.ProductDTO;
import com.api.shoppingCart.exception.ItemNotFoundException;
import com.api.shoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductServiceClient productServiceClient;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productServiceClient.getAllProducts();
    }

    @Override
    public ProductDTO getASingleProduct(Integer id) {
        return Optional.ofNullable(productServiceClient.getASingleProduct(id)).orElseThrow(() -> new ItemNotFoundException(String.format(" - %s", id)));
    }

}
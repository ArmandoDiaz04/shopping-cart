package com.api.shoppingCart.service;

import com.api.shoppingCart.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> getAllProducts();

    public ProductDTO getASingleProduct(Integer id);

}
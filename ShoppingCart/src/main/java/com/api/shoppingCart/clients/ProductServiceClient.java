package com.api.shoppingCart.clients;

import com.api.shoppingCart.dto.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "products", url = "https://fakestoreapi.com", path = "/products")
public interface ProductServiceClient {

    @GetMapping
    List<ProductDTO> getAllProducts();

    @GetMapping("/{id}")
    ProductDTO getASingleProduct(@PathVariable(name = "id") Integer id);
}

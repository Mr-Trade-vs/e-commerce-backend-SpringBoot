package com.shopnow.demo.model;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductStore repositoryProducts;

    public ProductService(ProductStore repositoryProducts) {
        this.repositoryProducts = repositoryProducts;
    }

    private Product idGeneration(Product product) {

        Optional<Product> lastProduct = repositoryProducts.findTopByOrderByIdDesc();

        if (lastProduct.isEmpty()) {
            product.setId("A00001");
            return product;
        }

        String idProduct = lastProduct.get().getId();

        int updateId = Integer.parseInt(idProduct.substring(1));

    }
    
}

package com.shopnow.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shopnow.demo.dto.ProductDTO;
import com.shopnow.demo.model.Product;
import com.shopnow.demo.repository.IProductStore;
import com.shopnow.demo.service.interf.IProductService;

@Service
public class ProductService implements IProductService {

    private final IProductStore repositoryProducts;

    public ProductService(IProductStore repositoryProducts) {
        this.repositoryProducts = repositoryProducts;
    }

    @Override
    public Product addProduct(ProductDTO product) {
        Product save = new Product(null, product.getName(), product.getUnitaryPrice(), product.getStock());
        save = idGeneration(save);
        repositoryProducts.save(save);
        return save;
    }

    private Product idGeneration(Product product) {

        Optional<Product> lastProduct = repositoryProducts.findTopByOrderByIdDesc();

        if (lastProduct.isEmpty()) {
            product.setId("A00001");
            return product;
        }

        String idProduct = lastProduct.get().getId();

        int updateId = Integer.parseInt(idProduct.substring(1));
        updateId++;

        product.setId(String.format("A%04d", updateId));
        return product;

    }
    
}

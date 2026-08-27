package com.shopnow.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopnow.demo.dto.ProductDTO;
import com.shopnow.demo.model.Product;
import com.shopnow.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ControllerProducts {

    private ProductService productService;

    public ControllerProducts(ProductService productManagment) {
        this.productService = productManagment;
    }

    @PostMapping("/addProduct") 
    public ResponseEntity<Product> addProduct (@RequestBody ProductDTO productDTO) {
        
        Product productToAdd = productService.addProduct(productDTO);

        return ResponseEntity.ok(productToAdd);

    }
}

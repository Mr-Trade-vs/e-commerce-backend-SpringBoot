package com.shopnow.demo.service.interf;

import com.shopnow.demo.dto.ProductDTO;
import com.shopnow.demo.model.Product;

public interface IProductService {

    Product addProduct(ProductDTO product);
    
    Product findProduct(String id);

}

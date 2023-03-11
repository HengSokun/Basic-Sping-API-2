package com.example.hengapi.service;

import com.example.hengapi.model.Products;
import com.example.hengapi.model.request.ProductRequest;

import java.util.List;

public interface ProductService {
    List<Products> getAllProducts();
    Products getProductById(Integer productId);
    Integer addNewProduct(ProductRequest productRequest);
    Integer updateProductById(ProductRequest productRequest);

}

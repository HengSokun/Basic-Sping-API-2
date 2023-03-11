package com.example.hengapi.service;

import com.example.hengapi.model.Products;
import com.example.hengapi.model.request.ProductRequest;

import java.util.List;

public interface ProductService {
    List<Products> getAllProducts();

    Products getProductById(Integer productId);

    Products addNewProduct(Products products);

    boolean deleteProductById(Integer productID);

    Integer updateProductById(Integer productId, ProductRequest productRequests);

}

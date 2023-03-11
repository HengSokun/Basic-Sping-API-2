package com.example.hengapi.service.service_implement;

import com.example.hengapi.model.Products;
import com.example.hengapi.model.request.ProductRequest;
import com.example.hengapi.repository.ProductRepository;
import com.example.hengapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Products getProductById(Integer productId) {
        return null;
    }

    @Override
    public Integer addNewProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    public Integer updateProductById(ProductRequest productRequest) {
        return null;
    }
}

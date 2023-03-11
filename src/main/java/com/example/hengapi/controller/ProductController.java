package com.example.hengapi.controller;

import com.example.hengapi.model.Products;
import com.example.hengapi.model.request.ProductRequest;
import com.example.hengapi.model.response.ProductResponse;
import com.example.hengapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//   Get all product
    @GetMapping("/all-product")
    @Operation(summary = "Get all products from list")
    public ResponseEntity<ProductResponse<List<Products>>> getAllProducts(){
        ProductResponse<List<Products>> productResponse = ProductResponse.<List<Products>>builder()
                .payload(productService.getAllProducts())
                .message("Successfully fetch all products")
                .success(true)
                .build();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    //    Get product by ID from list
    @GetMapping("/product_id/{productId}")
    @Operation(summary = "Get product by Id")
    public ResponseEntity<ProductResponse<Products>> getProductById (@PathVariable("productId") Integer productId){

        if (productService.getProductById(productId) != null) {
            ProductResponse<Products> productResponse = ProductResponse.<Products>builder()
                    .payload(productService.getProductById(productId))
                    .message("Successfully get product by ID")
                    .success(true)
                    .build();
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //    Insert new product to the list with @request body
    @PostMapping("/add-product")
    @Operation(summary = "Insert new product to list")
    public ResponseEntity<?> addNewProduct(@RequestBody Products products){
        ProductResponse<Products> productResponse = ProductResponse.<Products>builder()
                .payload(productService.addNewProduct(products))
                .message("Successfully added product to list")
                .success(true).build();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    //    Delete product to the list with @path variable
    @DeleteMapping("/delete_product/{product_id}")
    @Operation(summary = "Delete product by ID from list")
    public ResponseEntity<?> deleteProductById(@PathVariable("product_id") Integer productID){

        if (productService.deleteProductById(productID)) {
            ProductResponse<Products> productResponse = ProductResponse.<Products>builder()
                    .payload(productService.getProductById(productID))
                    .message("Successfully delete the product")
                    .success(true)
                    .build();
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //    Update product by ID
    @PutMapping("/update/{product_id}")
    @Operation(summary = "Update product by Id")
    public ResponseEntity<ProductResponse<Products>> updateProductById(@PathVariable("product_id") Integer productId, @RequestBody ProductRequest productRequests){

        ProductResponse<Products> productResponse = null;
        Integer productResponseUpdate  = productService.updateProductById(productId, productRequests);
        if (productResponseUpdate != null) {
            productResponse = ProductResponse.<Products>builder()
                    .payload(productService.getProductById(productId))
                    .message("Successfully added product to list")
                    .success(true).build();
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

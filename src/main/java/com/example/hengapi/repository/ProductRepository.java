package com.example.hengapi.repository;

import com.example.hengapi.model.Products;
import com.example.hengapi.model.request.ProductRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepository {
//    @Results({
//            @Result(property = "productId", column = "product_id"),
//            @Result(property = "productName", column = "product_name"),
//            @Result(property = "productPrice", column = "product_price")
//    })

//  Show all data from table
    @Select("SELECT * FROM products")
    @Result(property = "productId", column = "product_id")
    @Result(property = "productName", column = "product_name")
    @Result(property = "productPrice", column = "product_price")
    List<Products> findAllProducts();

//  Query finding the product from table
    @Select("SELECT * FROM products WHERE product_id = #{productId}")
    @Result(property = "productId", column = "product_id")
    @Result(property = "productName", column = "product_name")
    @Result(property = "productPrice", column = "product_price")
    Products findProductsById(@Param("productId") Integer productId);

//  Query new product to the table
    @Insert("INSERT INTO products(product_name, product_price) " +
            "VALUES(#{products.productName}, #{products.productPrice}) " +
            "RETURNING *")
    @Result(property = "productId", column = "product_id")
    @Result(property = "productName", column = "product_name")
    @Result(property = "productPrice", column = "product_price")
    Products addNewProducts(@Param("products") Products products);

//  Query delete product by id from table
    @Delete("DELETE FROM products WHERE product_id = #{productID}")
    @Result(property = "productId", column = "product_id")
    @Result(property = "productName", column = "product_name")
    @Result(property = "productPrice", column = "product_price")
    boolean deleteProductById(@Param("productID") Integer productID);

//    Query update product by ID from table
    @Select("UPDATE products " +
            "SET product_name = #{productRequests.productName}, " +
            "product_price = #{productRequests.productPrice} " +
            "WHERE product_id = #{productId} " +
            "RETURNING * ")
    @Result(property = "productId", column = "product_id")
    @Result(property = "productName", column = "product_name")
    @Result(property = "productPrice", column = "product_price")
    Integer updateProductsById(@Param("productId") Integer productId, @Param("productRequests") ProductRequest productRequests);
}

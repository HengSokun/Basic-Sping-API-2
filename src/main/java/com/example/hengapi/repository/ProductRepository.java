package com.example.hengapi.repository;

import com.example.hengapi.model.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepository {
    @Results({
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productPrice", column = "product_price")
    })

    @Select("SELECT * FROM products")


    List<Products> findAllProducts();
}

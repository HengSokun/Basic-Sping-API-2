package com.example.hengapi.repository;

import com.example.hengapi.model.Customers;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerRepository {

    @Results({
            @Result(property = "customerID", column = "customer_id"),
            @Result(property = "customerName", column = "customer_name"),
            @Result(property = "customerAddress", column = "customer_address"),
            @Result(property = "customerPhone", column = "customer_phone")
    })
    @Select("SELECT * FROM customers")
//    @Result(property = "customerID", column = "customer_id")
    List<Customers> findAllCustomer();
}

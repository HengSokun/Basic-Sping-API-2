package com.example.hengapi.repository;

import com.example.hengapi.model.Customers;
import com.example.hengapi.model.request.CustomerRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerRepository {

//    @Results({
//            @Result(property = "customerID", column = "customer_id"),
//            @Result(property = "customerName", column = "customer_name"),
//            @Result(property = "customerAddress", column = "customer_address"),
//            @Result(property = "customerPhone", column = "customer_phone")
//    })
    @Select("SELECT * FROM customers")
    @Result(property = "customerID", column = "customer_id")
    @Result(property = "customerName", column = "customer_name")
    @Result(property = "customerAddress", column = "customer_address")
    @Result(property = "customerPhone", column = "customer_phone")
    List<Customers> findAllCustomer();

    @Select("SELECT * FROM customers WHERE customer_id = #{customerId}")
    @Result(property = "customerID", column = "customer_id")
    @Result(property = "customerName", column = "customer_name")
    @Result(property = "customerAddress", column = "customer_address")
    @Result(property = "customerPhone", column = "customer_phone")
    Customers getCustomerById(Integer customerId);

    @Select("INSERT INTO customers(customer_name, customer_address, customer_phone) " +
            "VALUES (#{customerRequest.customerName}, #{customerRequest.customerAddress}, #{customerRequest.customerPhone} " +
            "RETURNING *")
    Integer insertCustomer(@Param("customerRequest") CustomerRequest customerRequest);

    @Delete("DELETE FORM customers WHERE customer_id = #{customerId}")
    boolean deleteCustomerById(@Param("customerId") Integer customerId);
}

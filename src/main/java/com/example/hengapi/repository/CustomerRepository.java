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

//   Query all data in table
    @Select("SELECT * FROM customers")
    @Result(property = "customerID", column = "customer_id")
    @Result(property = "customerName", column = "customer_name")
    @Result(property = "customerAddress", column = "customer_address")
    @Result(property = "customerPhone", column = "customer_phone")
    List<Customers> findAllCustomer();

//    Select customer by ID
    @Select("SELECT * FROM customers WHERE customer_id = #{customerId}")
    @Result(property = "customerID", column = "customer_id")
    @Result(property = "customerName", column = "customer_name")
    @Result(property = "customerAddress", column = "customer_address")
    @Result(property = "customerPhone", column = "customer_phone")
    Customers getCustomerById(Integer customerId);


//    Insert data query
    @Select("INSERT INTO customers(customer_name, customer_address, customer_phone) " +
            "VALUES (#{customers.customerName}, #{customers.customerAddress}, #{customers.customerPhone}) " +
            "RETURNING * ")
    @Result(property = "customerID", column = "customer_id")
    @Result(property = "customerName", column = "customer_name")
    @Result(property = "customerAddress", column = "customer_address")
    @Result(property = "customerPhone", column = "customer_phone")
    Customers insertCustomer(@Param("customers") Customers customers);

//    Delete data by ID
    @Delete("DELETE FROM customers WHERE customer_id = #{customerId}")
    @Result(property = "customerID", column = "customer_id")
    @Result(property = "customerName", column = "customer_name")
    @Result(property = "customerAddress", column = "customer_address")
    @Result(property = "customerPhone", column = "customer_phone")
    boolean deleteCustomerById(@Param("customerId") Integer customerId);

//    Update data query
    @Select("UPDATE customers " +
            "SET customer_name = #(customerRequests.customerName}, " +
            "customer_address = #{customerRequests.customerAddress}, " +
            "customer_phone = #{customerRequests.customerPhone} " +
            "WHERE customer_id = #{customerId} " +
            "RETURNING * ")
    @Result(property = "customerID", column = "customer_id")
    @Result(property = "customerName", column = "customer_name")
    @Result(property = "customerAddress", column = "customer_address")
    @Result(property = "customerPhone", column = "customer_phone")
    Integer updateCustomerById(Integer customerId, @Param("customerRequests") CustomerRequest customerRequest);
}

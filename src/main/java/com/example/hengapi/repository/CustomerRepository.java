package com.example.hengapi.repository;

import com.example.hengapi.model.Customers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerRepository {

    @Select("SELECT * FROM customers")
    List<Customers> findAllCustomer();
}

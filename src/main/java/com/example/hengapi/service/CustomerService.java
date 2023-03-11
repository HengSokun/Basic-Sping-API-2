package com.example.hengapi.service;

import com.example.hengapi.model.Customers;
import com.example.hengapi.model.request.CustomerRequest;

import java.util.List;

public interface CustomerService {

    List<Customers> getAllCustomers();
    Customers addNewCustomer(Customers customerRequest);
    Customers getCustomerById(Integer customerId);
    boolean deleteCustomerById(Integer customerId);
    Integer updateCustomerById(Integer customerId, CustomerRequest customerRequests);
}

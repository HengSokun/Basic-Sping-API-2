package com.example.hengapi.service.service_implement;

import com.example.hengapi.model.Customers;
import com.example.hengapi.model.request.CustomerRequest;
import com.example.hengapi.repository.CustomerRepository;
import com.example.hengapi.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    Get all customer from list
    @Override
    public List<Customers> getAllCustomers() {
        return customerRepository.findAllCustomer();
    }

    @Override
    public Integer addNewCustomer(CustomerRequest customerRequest) {
        return customerRepository.insertCustomer(customerRequest);
    }

    @Override
    public Customers getCustomerById(Integer customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public boolean deleteCustomerById(Integer customerId) {
        return customerRepository.deleteCustomerById(customerId);
    }

    @Override
    public Integer updateCustomerById(CustomerRequest customerRequest) {
        return null;
    }
}

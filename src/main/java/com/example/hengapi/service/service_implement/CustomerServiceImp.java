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

    @Override
    public List<Customers> getAllCustomers() {
        return customerRepository.findAllCustomer();
    }

    @Override
    public Integer addNewCustomer(CustomerRequest customerRequest) {
        return null;
    }

    @Override
    public Customers getCustomerById(Integer customerId) {
        return null;
    }

    @Override
    public boolean deleteCustomerById(Integer customerId) {
        return false;
    }

    @Override
    public Integer updateCustomerById(CustomerRequest customerRequest) {
        return null;
    }
}

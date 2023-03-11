package com.example.hengapi.controller;

import com.example.hengapi.model.Customers;
import com.example.hengapi.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all-customer")
    @Operation(summary = "Get all customer from list")
    public ResponseEntity<List<Customers>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
}

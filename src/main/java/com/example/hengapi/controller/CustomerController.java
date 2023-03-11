package com.example.hengapi.controller;

import com.example.hengapi.model.Customers;
import com.example.hengapi.model.response.CustomerResponse;
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

//    Inject by constructor
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    Get all customer from list
    @GetMapping("/all-customer")
    @Operation(summary = "Get all customer from list")
    public ResponseEntity<CustomerResponse<List<Customers>> > getAllCustomer(){
        CustomerResponse<List<Customers>> customerResponse = CustomerResponse.<List<Customers>>builder()
                .payload(customerService.getAllCustomers())
                .message("Fetch all customer data successfully")
                .success(true).build();
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

//    Get author by Id from list
    @GetMapping("/customer_id/{customerId}")
    @Operation(summary = "Get customer by Id")
    public ResponseEntity<CustomerResponse<Customers>> getCustomerById (@PathVariable("customerId") Integer customerId){

        if (customerService.getCustomerById(customerId) != null) {
            CustomerResponse<Customers> customerResponse = CustomerResponse.<Customers>builder()
                    .payload(customerService.getCustomerById(customerId))
                    .message("Successfully get customer by ID")
                    .success(true)
                    .build();
            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Insert new customer to the list with @request body
//    @RequestMapping("add-customer")
//    @Operation(summary = "Insert new customer to list")
//    public ResponseEntity<CustomerResponse<List<Customers>>> addNewCustomer(@RequestBody ){
//        CustomerResponse<List<Customers>> customerResponse = CustomerResponse.<List<Customers>>builder()
////                .payload(customerService.addNewCustomer())
//                .message("Successfully added customer to list")
//                .success(true).build();
//        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
//    }
}

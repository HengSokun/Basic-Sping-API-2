package com.example.hengapi.controller;

import com.example.hengapi.model.Customers;
import com.example.hengapi.model.request.CustomerRequest;
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

//    Get author by ID from list
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
    @PostMapping("/add-customer")
    @Operation(summary = "Insert new customer to list")
    public ResponseEntity<?> addNewCustomer(@RequestBody Customers customers){
        CustomerResponse<Customers> customerResponse = CustomerResponse.<Customers>builder()
                .payload(customerService.addNewCustomer(customers))
                .message("Successfully added customer to list")
                .success(true).build();
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

//    Delete customer to the list with @path variable
    @DeleteMapping("/delete_customer/{customer_id}")
    @Operation(summary = "Delete customer by ID from list")
    public ResponseEntity<?> deleteCustomerById(@PathVariable("customer_id") Integer customerID){

        if (customerService.deleteCustomerById(customerID)) {
            CustomerResponse<Customers> customerResponse = CustomerResponse.<Customers>builder()
                    .payload(customerService.getCustomerById(customerID))
                    .message("Successfully delete the customer")
                    .success(true)
                    .build();
            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Update customer by ID
    @PutMapping("/update/{customer_id}")
    @Operation(summary = "Update customer by Id")
    public ResponseEntity<CustomerResponse<Customers>> updateCustomerById(@PathVariable("customer_id") Integer customerId, @RequestBody CustomerRequest customerRequests){

        CustomerResponse<Customers> customerResponse = null;
        Integer customerResponseUpdate  = customerService.updateCustomerById(customerId, customerRequests);
        if (customerResponseUpdate != null) {
            customerResponse = CustomerResponse.<Customers>builder()
                    .payload(customerService.getCustomerById(customerId))
                    .message("Successfully added customer to list")
                    .success(true).build();
            return new ResponseEntity<>(customerResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

package com.example.hengapi.controller;

import com.example.hengapi.model.Customers;
import com.example.hengapi.model.Invoices;
import com.example.hengapi.model.Products;
import com.example.hengapi.model.response.InvoiceResponse;
import com.example.hengapi.service.CustomerService;
import com.example.hengapi.service.InvoiceService;
import com.example.hengapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final CustomerService customerService;
    private final ProductService productService;

    public InvoiceController(InvoiceService invoiceService, CustomerService customerService, ProductService productService) {
        this.invoiceService = invoiceService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @GetMapping("/get-all-invoice")
    public ResponseEntity<List<Invoices>> getAllInvoices() {
        List<Invoices> invoices = invoiceService.getAllInvoices();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add a new invoice
//    @PostMapping("/add-new-invoice")
//    public ResponseEntity<Response<Invoices>> addNewInvoice(@RequestBody Invoices invoice) {
//        try {
//            // Set the customer and products for the invoice
//            Customers customer = customerService.getCustomerById(invoice.getCustomer().getCustomerId());
//            List<Products> products = new ArrayList<>();
//            for (Products product : invoice.getProducts()) {
//                products.add(productService.getProductById(product.getProductId()));
//            }
//            invoice.setCustomer(customer);
//            invoice.setProducts(products);
//            // Save the invoice
//            invoiceService.saveInvoice(invoice);
//            // Create the response
//            Response<Invoice> response = new Response<>(invoice, "Invoice added successfully", true);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            // Create the response
//            Response<Invoice> response = new Response<>(null, e.getMessage(), false);
//            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
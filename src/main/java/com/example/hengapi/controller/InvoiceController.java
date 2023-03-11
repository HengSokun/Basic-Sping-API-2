package com.example.hengapi.controller;

import com.example.hengapi.model.Invoices;
import com.example.hengapi.model.request.InvoiceRequest;
import com.example.hengapi.model.response.InvoiceResponse;
import com.example.hengapi.service.CustomerService;
import com.example.hengapi.service.InvoiceService;
import com.example.hengapi.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
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


//    @GetMapping("/get-all-invoice")
//    public ResponseEntity<List<Invoices>> getAllInvoices() {
//        List<Invoices> invoices = invoiceService.getAllInvoices();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    //    Get all invoice from list
    @GetMapping("/all-invoice")
    @Operation(summary = "Get all invoice from list")
    public ResponseEntity<?> getAllInvoice() {
        InvoiceResponse<Invoices> invoiceResponse = InvoiceResponse.<Invoices>builder()
                .payload((Invoices) invoiceService.getAllInvoices())
                .message("Successfully get all invoices")
                .success(true)
                .build();
        return new ResponseEntity<>(invoiceResponse, HttpStatus.OK);
    }

    //    Get author by ID from list
    @GetMapping("/invoice_id/{invoiceId}")
    @Operation(summary = "Get invoice by Id")
    public ResponseEntity<InvoiceResponse<Invoices>> getInvoiceById (@PathVariable("invoiceId") Integer invoiceId){

        if (invoiceService.getInvoiceById(invoiceId) != null) {
            InvoiceResponse<Invoices> invoiceResponse = InvoiceResponse.<Invoices>builder()
                    .payload(invoiceService.getInvoiceById(invoiceId))
                    .message("Successfully get invoice by ID")
                    .success(true)
                    .build();
            return new ResponseEntity<>(invoiceResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //    Insert new invoice to the list with @request body
    @PostMapping("/add-invoice")
    @Operation(summary = "Insert new invoice to list")
    public ResponseEntity<?> addNewInvoice(@RequestBody Invoices invoices){
        InvoiceResponse<Invoices> invoiceResponse = InvoiceResponse.<Invoices>builder()
                .payload(invoiceService.addNewInvoice(invoices))
                .message("Successfully added invoice to list")
                .success(true).build();
        return new ResponseEntity<>(invoiceResponse, HttpStatus.OK);
    }

    //    Delete invoice to the list with @path variable
    @DeleteMapping("/delete_invoice/{invoice_id}")
    @Operation(summary = "Delete invoice by ID from list")
    public ResponseEntity<?> deleteInvoiceById(@PathVariable("invoice_id") Integer invoiceID){

        if (invoiceService.deleteInvoiceById(invoiceID)) {
            InvoiceResponse<Invoices> invoiceResponse = InvoiceResponse.<Invoices>builder()
                    .payload(invoiceService.getInvoiceById(invoiceID))
                    .message("Successfully delete the invoice")
                    .success(true)
                    .build();
            return new ResponseEntity<>(invoiceResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //    Update invoice by ID
    @PutMapping("/update/{invoice_id}")
    @Operation(summary = "Update invoice by Id")
    public ResponseEntity<InvoiceResponse<Invoices>> updateInvoiceById(@PathVariable("invoice_id") Integer invoiceId, @RequestBody InvoiceRequest invoiceRequests){

        InvoiceResponse<Invoices> invoiceResponse = null;
        Integer invoiceResponseUpdate  = invoiceService.updateInvoiceById(invoiceId, invoiceRequests);
        if (invoiceResponseUpdate != null) {
            invoiceResponse = InvoiceResponse.<Invoices>builder()
                    .payload(invoiceService.getInvoiceById(invoiceId))
                    .message("Successfully added invoice to list")
                    .success(true).build();
            return new ResponseEntity<>(invoiceResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
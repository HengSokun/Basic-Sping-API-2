package com.example.hengapi.service;

import com.example.hengapi.model.Invoices;
import com.example.hengapi.model.request.InvoiceRequest;

import java.util.List;

public interface InvoiceService {
    List<Invoices> getAllInvoices();
    Integer addNewInvoice(InvoiceRequest invoiceRequest);
    Invoices getInvoiceById (Integer invoiceId);
    boolean deleteInvoiceById (InvoiceRequest invoiceRequest);
    Integer updateInvoiceById (InvoiceRequest invoiceRequest);

}

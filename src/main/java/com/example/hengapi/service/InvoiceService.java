package com.example.hengapi.service;

import com.example.hengapi.model.Invoices;
import com.example.hengapi.model.request.InvoiceRequest;

import java.util.List;

public interface InvoiceService {

    List<Invoices> getAllInvoices();

    Invoices getInvoiceById(Integer invoiceId);

    Invoices addNewInvoice(Invoices invoices);

    boolean deleteInvoiceById(Integer invoiceID);

    Integer updateInvoiceById(Integer invoiceId, InvoiceRequest invoiceRequests);
}

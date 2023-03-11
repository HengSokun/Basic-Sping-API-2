package com.example.hengapi.service.service_implement;

import com.example.hengapi.model.Invoices;
import com.example.hengapi.model.request.InvoiceRequest;
import com.example.hengapi.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceImp implements InvoiceService {
    @Override
    public List<Invoices> getAllInvoices() {
        return null;
    }

    @Override
    public Integer addNewInvoice(InvoiceRequest invoiceRequest) {
        return null;
    }

    @Override
    public Invoices getInvoiceById(Integer invoiceId) {
        return null;
    }

    @Override
    public boolean deleteInvoiceById(InvoiceRequest invoiceRequest) {
        return false;
    }

    @Override
    public Integer updateInvoiceById(InvoiceRequest invoiceRequest) {
        return null;
    }
}

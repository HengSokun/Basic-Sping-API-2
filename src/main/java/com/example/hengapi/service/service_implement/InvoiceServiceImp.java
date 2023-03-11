package com.example.hengapi.service.service_implement;

import com.example.hengapi.model.Invoices;
import com.example.hengapi.model.request.InvoiceRequest;
import com.example.hengapi.repository.InvoiceRepository;
import com.example.hengapi.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceImp implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImp(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoices> getAllInvoices() {
        return invoiceRepository.getAllInvoices();
    }

    @Override
    public Invoices getInvoiceById(Integer invoiceId) {
        return (Invoices) invoiceRepository.getProductByInvoiceId(invoiceId);
    }

    @Override
    public Invoices addNewInvoice(Invoices invoices) {
        return null;
    }

    @Override
    public boolean deleteInvoiceById(Integer invoiceID) {
        return false;
    }

    @Override
    public Integer updateInvoiceById(Integer invoiceId, InvoiceRequest invoiceRequests) {
        return null;
    }
}

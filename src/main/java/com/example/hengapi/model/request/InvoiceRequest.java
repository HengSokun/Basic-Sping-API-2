package com.example.hengapi.model.request;

import com.example.hengapi.model.Invoices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceRequest {
    private Integer invoiceId;
    private String customerId;
    private List<Invoices> items;
}

package com.example.hengapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoices {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer invoiceId;
    private Timestamp invoiceDate;

}

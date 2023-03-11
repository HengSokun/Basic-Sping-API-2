package com.example.hengapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customers {
    private Integer customerID;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

}

package com.example.hengapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customers {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer customerID;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

}

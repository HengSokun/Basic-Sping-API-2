package com.example.hengapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer productId;
    private String productName;
    private float productPrice;
}

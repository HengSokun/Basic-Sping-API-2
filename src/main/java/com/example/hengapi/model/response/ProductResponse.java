package com.example.hengapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse <P> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private P payload;
    private String message;
    private boolean success;
}

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
public class CustomerResponse<R> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private R payload;
    private String message;
    private boolean success;

}

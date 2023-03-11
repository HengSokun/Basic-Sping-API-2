package com.example.hengapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class URLResponse<P> {
    private Timestamp timestamp;
    private P payload;
}

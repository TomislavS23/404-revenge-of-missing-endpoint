package dev.rme.model.dto.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UpdateProductRequest {
    private BigInteger id;
    private Double price;
}

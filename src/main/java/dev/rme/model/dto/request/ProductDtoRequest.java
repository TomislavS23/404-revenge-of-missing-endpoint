package dev.rme.model.dto.request;

import lombok.Data;

import java.time.Instant;

@Data
public class ProductDtoRequest {
    private Integer idCategory;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Instant updatedAt;
}
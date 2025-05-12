package dev.rme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link dev.rme.model.database.Product}
 */
@Value
@AllArgsConstructor
public class ProductDto implements Serializable {
    Long id;
    BigDecimal price;
    String shopName;
    BigDecimal couponPrice;
    Integer inventory;
    String title;
    String mainImageUrl;
}
package dev.rme.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for {@link com.axiara.axiaraapi.model.Order}
 */
@Data
@AllArgsConstructor
public class OrderRequestDto {
    Integer idUser;
    Double totalAmount;
    Integer paymentMethodId;
    String shippingAddress;
    Boolean delivered;
}
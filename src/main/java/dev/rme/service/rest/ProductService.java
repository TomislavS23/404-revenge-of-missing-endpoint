package dev.rme.service.rest;

import dev.rme.error.ErrorProperties;
import dev.rme.error.ErrorResponseBuilder;
import dev.rme.exception.RestControllerException;
import dev.rme.model.dto.Product;
import dev.rme.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ErrorProperties errorProperties;
    private final ErrorResponseBuilder errorResponseBuilder;

    public void insertProduct(Product product) {
        try {
            productRepository.insert(
                    product.getItemId(),
                    product.getPrice(),
                    product.getShopName(),
                    product.getCouponPrice(),
                    product.getInventory(),
                    product.getTitle(),
                    product.getMainImageUrl()
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getProductInsertFailed()));
        }
    }
}

package dev.rme.service.rest;

import dev.rme.error.ErrorProperties;
import dev.rme.error.ErrorResponseBuilder;
import dev.rme.exception.RestControllerException;
import dev.rme.model.database.Product;
import dev.rme.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ErrorProperties errorProperties;
    private final ErrorResponseBuilder errorResponseBuilder;

    public List<Product> findAllProducts() {
        return productRepository.findAllProducts()
                .orElseThrow(() ->
                        new RestControllerException(errorResponseBuilder.build(errorProperties.getProductsNotFound())));
    }

    public Product findProductById(BigInteger id) {
        return productRepository.findProductById(id)
                .orElseThrow(() ->
                        new RestControllerException(errorResponseBuilder.build(errorProperties.getProductNotFound())));
    }

    public void insertProduct(dev.rme.model.dto.xml.Product product) {
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
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getProductInsertFailed()));
        }
    }

    public void updateProduct(BigInteger id, Double price) {
        try {
            productRepository.update(id, price);
        } catch (RestControllerException e) {
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getFailedProductUpdate()));
        }
    }

    public void deleteProduct(BigInteger id) {
        try {
            productRepository.delete(id);
        } catch (RestControllerException e) {
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getProductDeleteFailed()));
        }
    }
}

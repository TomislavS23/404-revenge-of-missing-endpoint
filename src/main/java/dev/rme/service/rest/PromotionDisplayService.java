package dev.rme.service.rest;

import dev.rme.error.ErrorProperties;
import dev.rme.error.ErrorResponseBuilder;
import dev.rme.exception.RestControllerException;
import dev.rme.repository.PromotionDisplayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromotionDisplayService {
    private final PromotionDisplayRepository promotionDisplayRepository;
    private final ErrorProperties errorProperties;
    private final ErrorResponseBuilder errorResponseBuilder;

    public void insert(Long id, String typeName) {
        try {
            promotionDisplayRepository.insert(id, typeName);
        } catch (Exception e) {
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getProductDisplayInsertFailed()));
        }
    }
}

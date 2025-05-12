package dev.rme.service.rest;

import dev.rme.error.ErrorProperties;
import dev.rme.error.ErrorResponseBuilder;
import dev.rme.exception.RestControllerException;
import dev.rme.repository.MultiLanguageInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class MultiLanguageInfoService {
    private final MultiLanguageInfoRepository multiLanguageInfoRepository;
    private final ErrorResponseBuilder errorResponseBuilder;
    private final ErrorProperties errorProperties;

    public void insert(Long id, String language, String title) {
        try {
            multiLanguageInfoRepository.insert(id, language, title);
        } catch (Exception e) {
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getMultiLanguageInfoInsertFailed()));
        }
    }

    public void delete(BigInteger id) {
        try {
            multiLanguageInfoRepository.delete(id);
        } catch (Exception e) {
            throw new RestControllerException(errorResponseBuilder.build(errorProperties.getMultiLanguageInfoDeleteFailed()));
        }
    }
}

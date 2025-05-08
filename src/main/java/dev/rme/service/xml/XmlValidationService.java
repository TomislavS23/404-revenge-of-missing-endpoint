package dev.rme.service.xml;

import dev.rme.exception.ValidationException;
import dev.rme.model.dto.Product;
import dev.rme.model.generated.SearchResponse;
import dev.rme.repository.XmlValidation;
import dev.rme.service.rest.MultiLanguageInfoService;
import dev.rme.service.rest.ProductService;
import dev.rme.service.rest.PromotionDisplayService;
import dev.rme.utils.Constants;
import dev.rme.utils.xml.XMLUtils;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class XmlValidationService implements XmlValidation {
    private final XMLUtils xmlUtils;
    private final ProductService productService;
    private final PromotionDisplayService promotionDisplayService;
    private final MultiLanguageInfoService multiLanguageInfoService;


    @Override
    public void validateWithXsd(String xml) {
        try {
            var product = (Product) xmlUtils.validateAndConvert(Product.class, xml, Constants.XSD_SCHEMA_PATH);
            productService.insertProduct(product);
            promotionDisplayService.insert(product.getItemId(), product.getPromotionDisplay().getTypeName());
            multiLanguageInfoService.insert(
                    product.getItemId(),
                    product.getMultiLanguageInfo().language,
                    product.getMultiLanguageInfo().getTitle()
            );
        } catch (JAXBException | SAXException e) {
            throw new ValidationException(e.getCause().toString());
        }
    }

    @Override
    public void validateWithRng(String xml) {
        try {
            if (!xmlUtils.validateAgainstRng(xml, Constants.RNG_SCHEMA_PATH)) {
                throw new ValidationException("RNG validation failed because of bad XML formatting " +
                        "or wrong elements were given.");
            }

            var product = (Product) xmlUtils.convertToObject(Product.class, xml);
            productService.insertProduct(product);
            promotionDisplayService.insert(product.getItemId(), product.getPromotionDisplay().getTypeName());
            multiLanguageInfoService.insert(
                    product.getItemId(),
                    product.getMultiLanguageInfo().language,
                    product.getMultiLanguageInfo().getTitle()
            );
        } catch (IOException | SAXException | JAXBException e) {
            throw new ValidationException(e.getMessage());
        }
    }

    @Override
    public void validateResponseWithXsd(Object response) {
        try {
            xmlUtils.marshalResponseAndValidate(response, SearchResponse.class, Constants.FULL_XSD_SCHEMA_PATH);
        } catch (Exception e) {
            throw new ValidationException(e.getMessage());
        }
    }
}

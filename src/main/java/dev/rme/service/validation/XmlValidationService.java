package dev.rme.service.validation;

import dev.rme.exception.ValidationException;
import dev.rme.model.xml.Product;
import dev.rme.repository.XmlValidation;
import dev.rme.utils.Constants;
import dev.rme.utils.XMLUtils;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class XmlValidationService implements XmlValidation {
    private final XMLUtils XMLUtils;

    @Override
    public void validateWithXsd(String xml) {
        try {
            XMLUtils.validateAndConvert(Product.class, xml, Constants.XSD_SCHEMA_PATH);
            // TODO: insert element to database
        } catch (JAXBException | SAXException e) {
            throw new ValidationException(e.getCause().toString());
        }
    }

    @Override
    public void validateWithRng(String xml) {
        try {
            if (!XMLUtils.validateAgainstRng(xml, Constants.RNG_SCHEMA_PATH)) {
                throw new ValidationException("RNG validation failed because of bad XML formatting or wrong elements were given.");
            }
            // TODO: insert element to database
        } catch (IOException | SAXException e) {
            throw new ValidationException(e.getMessage());
        }
    }
}

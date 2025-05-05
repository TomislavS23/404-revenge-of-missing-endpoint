package dev.rme.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import com.thaiopensource.validate.SchemaReader;
import com.thaiopensource.validate.ValidationDriver;
import com.thaiopensource.validate.auto.AutoSchemaReader;
import dev.rme.exception.ValidationException;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@Component
public class XMLUtils {
    public void validateAndConvert(Class clazz, String xml, String schemaPath) throws JAXBException, SAXException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        var xsd = XMLUtils.class.getResourceAsStream(schemaPath);
        var schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        var schema = schemaFactory.newSchema(new StreamSource(xsd));
        unmarshaller.setSchema(schema);

        var reader = new StringReader(xml);
        unmarshaller.unmarshal(reader);
    }

    public Boolean validateAgainstRng(String xmlString, String schemaPath) throws IOException, SAXException {
        SchemaReader schemaReader = new AutoSchemaReader();
        ValidationDriver driver = new ValidationDriver(schemaReader);

        var rng = XMLUtils.class.getResourceAsStream(schemaPath);
        if (!driver.loadSchema(new InputSource(rng))) {
            throw new ValidationException("Schema validation failed");
        }

        try (InputStream xmlStream = new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8))) {
            return driver.validate(new InputSource(xmlStream));
        }
    }
}

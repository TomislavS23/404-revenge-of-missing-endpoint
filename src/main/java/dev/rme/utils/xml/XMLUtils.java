package dev.rme.utils.xml;

import java.io.*;
import java.nio.charset.StandardCharsets;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import com.thaiopensource.validate.SchemaReader;
import com.thaiopensource.validate.ValidationDriver;
import com.thaiopensource.validate.auto.AutoSchemaReader;
import dev.rme.exception.ValidationException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@Component
public class XMLUtils {
    public Object convertToObject(Class clazz, String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        var reader = new StringReader(xml);
        return unmarshaller.unmarshal(reader);
    }

    public Object validateAndConvert(Class clazz, String xml, String schemaPath) throws JAXBException, SAXException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        var xsd = XMLUtils.class.getResourceAsStream(schemaPath);
        var schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        var schema = schemaFactory.newSchema(new StreamSource(xsd));
        unmarshaller.setSchema(schema);

        var reader = new StringReader(xml);
        return unmarshaller.unmarshal(reader);
    }

    public void marshalResponseAndValidate(Object object, Class<?> clazz, String xsdPath) throws JAXBException, SAXException, IOException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        var writer = new StringWriter();
        marshaller.marshal(object, writer);
        var xmlString = writer.toString();

        var xsd = XMLUtils.class.getResourceAsStream(xsdPath);
        var sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
        var schema = sf.newSchema(new StreamSource(xsd));
        var validator = schema.newValidator();
        validator.validate(new javax.xml.transform.stream.StreamSource(new StringReader(xmlString)));
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

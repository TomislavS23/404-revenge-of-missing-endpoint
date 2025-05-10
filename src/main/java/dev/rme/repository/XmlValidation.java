package dev.rme.repository;

public interface XmlValidation {
    void validateWithXsdAndInsert(String xml);
    void validateWithRngAndInsert(String xml);
    void validateXmlResponseWithXsd(Object response);
}

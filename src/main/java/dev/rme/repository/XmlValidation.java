package dev.rme.repository;

public interface XmlValidation {
    void validateWithXsd(String xml);
    void validateWithRng(String xml);
    void validateResponseWithXsd(Object response);
}

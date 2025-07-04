package dev.rme.controller.rest;

import dev.rme.service.xml.XmlValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/404rme/validate/")
@RequiredArgsConstructor
public class XmlValidationController {
    private final XmlValidationService xmlValidationService;

    @PostMapping(path = "xsd", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Void> validateXmlAgainstXsd(@RequestBody String xml) {
        xmlValidationService.validateWithXsdAndInsert(xml);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "rng", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Void> validateXmlAgainstRng(@RequestBody String xml) {
        xmlValidationService.validateWithRngAndInsert(xml);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

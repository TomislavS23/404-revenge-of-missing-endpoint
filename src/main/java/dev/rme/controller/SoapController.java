package dev.rme.controller;

import dev.rme.model.generated.ItemsPort;
import dev.rme.model.generated.ItemsPortService;
import dev.rme.model.generated.SearchByPriceRequest;
import dev.rme.model.generated.SearchResponse;
import dev.rme.service.soap.SoapService;
import dev.rme.service.xml.XmlValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/404rme/soap")
@RequiredArgsConstructor
public class SoapController {
    private final SoapService soapService;
    private final XmlValidationService xmlValidationService;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<SearchResponse> searchByPrice(@RequestParam String price) {
        soapService.generateXmlFromRestApi();
        ItemsPortService service = new ItemsPortService();
        ItemsPort port = service.getItemsPortSoap11();

        SearchByPriceRequest request = new SearchByPriceRequest();
        request.setPrice(price);
        SearchResponse response = port.searchByPrice(request);

        xmlValidationService.validateResponseWithXsd(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

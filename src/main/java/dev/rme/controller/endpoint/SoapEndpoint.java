package dev.rme.controller.endpoint;

import dev.rme.model.generated.SearchByPriceRequest;
import dev.rme.model.generated.SearchResponse;
import dev.rme.service.soap.SoapService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class SoapEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap/model";
    private final SoapService soapService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchByPriceRequest")
    @ResponsePayload
    public SearchResponse searchByPrice(@RequestPayload SearchByPriceRequest request) {
        return soapService.filterXmlByPrice(request.getPrice());
    }
}

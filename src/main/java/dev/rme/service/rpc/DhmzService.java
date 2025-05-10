package dev.rme.service.rpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.rme.model.rpc.Hrvatska;
import dev.rme.utils.xml.XMLUtils;
import jakarta.xml.bind.JAXBException;

import org.springframework.stereotype.Service;

@Service
public class DhmzService {
    private final XMLUtils xmlUtils = new XMLUtils();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String findGrad(String filter, String xml) {
        try {
            var hrvatska = (Hrvatska) xmlUtils.unmarshall(Hrvatska.class, xml);
            var result = hrvatska.getGrad()
                    .stream()
                    .filter(grad -> grad.getGradIme().contains(filter))
                    .toList();

            return objectMapper.writeValueAsString(result);
        } catch (JAXBException | JsonProcessingException e) {
            return "[]";
        }
    }
}

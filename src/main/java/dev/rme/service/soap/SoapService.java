package dev.rme.service.soap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dev.rme.model.wsdl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.math.BigInteger;
import java.util.UUID;

@Service
public class SoapService {
    private final RestTemplate restTemplate;
    private final ObjectMapper xmlMapper;
    private static final String XML_FILE_PATH = "src/main/resources/soap/soap-data.xml";

    @Value("${rest.api.url}")
    private String restApiUrl;
    @Value("${rest.api.host}")
    private String host;
    @Value("${rest.api.key}")
    private String key;

    public SoapService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void generateXmlFromRestApi() {
        try {
            var xmlFile = new File(XML_FILE_PATH);

            if (xmlFile.exists()) return;

            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-host", host);
            headers.set("x-rapidapi-key", key);

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    restApiUrl,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            JsonNode jsonNode = new ObjectMapper().readTree(response.getBody());
            xmlMapper.writeValue(xmlFile, jsonNode);
        } catch (Exception e) {
            throw new RuntimeException("Error generating XML from REST API", e);
        }
    }


    public SearchResponse filterXmlByPrice(String price) {
        try {
            File xmlFile = new File(XML_FILE_PATH);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            String expression = String.format("//data/data[price='%s']", price);

            NodeList nodes = (NodeList) xpath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            SearchResponse response = new SearchResponse();
            response.setCode(BigInteger.valueOf(200));
            response.setMessage("SUCCESS");
            response.setTimestamp(System.currentTimeMillis());
            response.setTraceId(UUID.randomUUID().toString());

            ApiData apiData = new ApiData();
            apiData.setPageNo(BigInteger.ONE);
            apiData.setPageSize(BigInteger.valueOf(nodes.getLength()));

            for (int i = 0; i < nodes.getLength(); i++) {
                Element itemElement = (Element) nodes.item(i);
                Item item = new Item();

                // Map all fields from XML to Item object
                item.setItemId(Long.parseLong(getElementValue(itemElement, "itemId")));
                item.setPrice(getElementValue(itemElement, "price"));
                item.setShopName(getElementValue(itemElement, "shopName"));
                item.setCouponPrice(getElementValue(itemElement, "couponPrice"));
                item.setInventory(BigInteger.valueOf(Integer.parseInt(getElementValue(itemElement, "inventory"))));
                item.setTitle(getElementValue(itemElement, "title"));
                item.setMainImageUrl(getElementValue(itemElement, "mainImageUrl"));

                // Handle multiLanguageInfo
                Element multiLanguageElement = (Element) itemElement.getElementsByTagName("multiLanguageInfo").item(0);
                MultiLanguageInfo multiLanguageInfo = new MultiLanguageInfo();
                multiLanguageInfo.setLanguage(getElementValue(multiLanguageElement, "language"));
                multiLanguageInfo.setTitle(getElementValue(multiLanguageElement, "title"));
                item.setMultiLanguageInfo(multiLanguageInfo);

                // Handle promotionDisplays
                NodeList promotionDisplays = itemElement.getElementsByTagName("promotionDisplays");
                for (int j = 0; j < promotionDisplays.getLength(); j++) {
                    Element promotionElement = (Element) promotionDisplays.item(j);
                    PromotionDisplay promotionDisplay = new PromotionDisplay();
                    promotionDisplay.setTypeName(getElementValue(promotionElement, "typeName"));

                    NodeList promotionInfos = promotionElement.getElementsByTagName("promotionInfoList");
                    for (int k = 0; k < promotionInfos.getLength(); k++) {
                        Element promoInfoElement = (Element) promotionInfos.item(k);
                        PromotionInfo promoInfo = new PromotionInfo();
                        promoInfo.setActivityCode(getElementValue(promoInfoElement, "activityCode"));
                        promoInfo.setPromotionName(getElementValue(promoInfoElement, "promotionName"));
                        promotionDisplay.getPromotionInfoList().add(promoInfo);
                    }
                    item.getPromotionDisplays().add(promotionDisplay);
                }

                apiData.getData().add(item);
            }

            response.setData(apiData);
            return response;

        } catch (Exception e) {
            throw new RuntimeException("Error generating XML from REST API", e);
        }
    }

    private String getElementValue(Element parent, String tagName) {
        NodeList nodes = parent.getElementsByTagName(tagName);
        return nodes.getLength() > 0 ? nodes.item(0).getTextContent() : null;
    }
}

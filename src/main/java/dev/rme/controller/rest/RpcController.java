package dev.rme.controller.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.rme.model.rpc.Hrvatska;
import dev.rme.utils.xml.XMLUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/404rme/rpc")
public class RpcController {
    private XmlRpcClient rpcClient;

    public RpcController() {
        try {
            var config = new XmlRpcClientConfigImpl();
            config.setServerURL(URI.create("http://localhost:8081").toURL());
            config.setEnabledForExtensions(true);
            config.setContentLengthOptional(false);

            rpcClient = new XmlRpcClient();
            rpcClient.setConfig(config);
        } catch (Exception e) {
            log.error("Error while initializing XmlRpcClient {}", e.getMessage());
        }
    }

    @GetMapping("{filter}")
    public ResponseEntity<List<Hrvatska.Grad>> getGradovi(@PathVariable String filter) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://vrijeme.hr/hrvatska_n.xml"))
                    .build();
            var body = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            var obj = new Object[]{filter, body};
            var jsonResult = (String) rpcClient.execute("dhmz.findGrad", obj);

            ObjectMapper mapper = new ObjectMapper();
            var result = mapper.readValue(jsonResult, new TypeReference<List<Hrvatska.Grad>>() {});

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
        }
    }
}

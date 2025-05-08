package dev.rme.server;

import dev.rme.model.rpc.Hrvatska;
import dev.rme.service.rpc.DhmzService;
import lombok.extern.log4j.Log4j2;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

@Log4j2
public class DhmzServer {
    private DhmzServer() {
    }

    public static void startRpcServer() {
        try {
            log.info("Starting DHMZ RPC server.");

            var server = new WebServer(8081);
            var xmlRpcServer = server.getXmlRpcServer();

            var propertyHandlerMapping = new PropertyHandlerMapping();
            propertyHandlerMapping.addHandler("dhmz", DhmzService.class);
            xmlRpcServer.setHandlerMapping(propertyHandlerMapping);

            var config = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            config.setEnabledForExtensions(true);
            config.setContentLengthOptional(false);

            server.start();
            log.info("DHMZ RPC Server started on port{}", server.getPort());
        } catch (XmlRpcException | IOException e) {
            log.fatal("Error starting DHMZ RPC server{}", e.getMessage());
        }
    }
}

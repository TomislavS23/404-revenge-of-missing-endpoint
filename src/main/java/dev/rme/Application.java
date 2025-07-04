package dev.rme;

import dev.rme.server.DhmzServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        DhmzServer.startRpcServer();
    }

}

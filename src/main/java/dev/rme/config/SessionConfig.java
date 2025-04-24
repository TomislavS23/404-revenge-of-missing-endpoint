package dev.rme.config;

import jakarta.servlet.SessionTrackingMode;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@Configuration
public class SessionConfig implements WebMvcConfigurer {

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> servletContext.setSessionTrackingModes(
                Collections.singleton(SessionTrackingMode.COOKIE)
        );
    }
}

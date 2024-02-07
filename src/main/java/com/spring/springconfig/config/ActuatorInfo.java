package com.spring.springconfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@Endpoint(id = "appInfo")
public class ActuatorInfo {

    @Autowired
    private Environment environment;

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @ReadOperation
    public Map<String, String> getApplicationInformation() {

        return Map.of("PROFILES", String.join(", ", environment.getActiveProfiles()),
                "DATABASE", databaseUrl);
    }

}

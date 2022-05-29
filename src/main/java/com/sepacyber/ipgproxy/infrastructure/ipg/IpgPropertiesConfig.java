package com.sepacyber.ipgproxy.infrastructure.ipg;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "application.ipg")
public class IpgPropertiesConfig {
    @Value("${application.ipg.success-response-codes")
    private List<String> successResponseCodes;
}
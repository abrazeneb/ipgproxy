package com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = "com.sepacyber.ipgproxy.domainabstraction.provideradapter.ipg")
@Import(FeignClientsConfiguration.class)
public class IpgFeignConfiguration {

    /**
     * Set the Feign specific log level to log client REST requests.
     */
    @Bean
    Logger.Level feignLoggerLevel() {return Logger.Level.FULL;}
}




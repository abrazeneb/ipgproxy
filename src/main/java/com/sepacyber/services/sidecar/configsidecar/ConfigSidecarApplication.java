package com.sepacyber.services.sidecar.configsidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.sepacyber.services.sidecar.configsidecar.domain.entity.sql")
//RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP listens to the expiry events of redis entries
@EnableScheduling
public class ConfigSidecarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSidecarApplication.class, args);
    }

}

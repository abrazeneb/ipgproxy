package com.sepacyber.services.sidecar.configsidecar;

import com.sepacyber.services.sidecar.configsidecar.ConfigSidecarApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ConfigSidecarApplication.class);
    }

}

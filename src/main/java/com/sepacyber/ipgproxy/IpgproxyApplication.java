package com.sepacyber.ipgproxy;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import com.sepacyber.ipgproxy.application.util.ApplicationConstants;
import com.sepacyber.ipgproxy.application.util.DefaultProfileUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class IpgproxyApplication  implements InitializingBean {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(IpgproxyApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        loadApplicationStartup(env);
    }

    private static final Logger log = LoggerFactory.getLogger(IpgproxyApplication.class);

    private final Environment env;

    public IpgproxyApplication(Environment env) {this.env = env;}

    @Override
    public void afterPropertiesSet() throws Exception {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(ApplicationConstants.SPRING_PROFILE_DEVELOPMENT)
                && activeProfiles.contains(ApplicationConstants.SPRING_PROFILE_PRODUCTION)) {
            log.error("You have wrong configs on your application! It should not run " +
                    "with both the 'dev' and 'prod' profiles at the same time.");
        }

        if (activeProfiles.contains(ApplicationConstants.SPRING_PROFILE_PRODUCTION)
                && activeProfiles.contains(ApplicationConstants.SPRING_PROFILE_TEST)) {
            log.error("You have wrong configs on your application! It should not " +
                    "run with both the 'prod' and 'test' profiles at the same time.");
        }

    }

    public static void loadApplicationStartup(Environment env) {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());

        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port") != null ? env.getProperty("server.port") : "8080";
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Swagger: \t{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                activeProfiles.contains(ApplicationConstants.SPRING_PROFILE_SWAGGER) ? protocol + "://" + hostAddress + ":" + serverPort + contextPath + "swagger-ui/index.html" : "No Swagger Deployed",
                protocol,
                hostAddress,
                serverPort,
                env.getActiveProfiles());
    }

    @Bean
    public Pipeline pipeline(ObjectProvider<Command.Handler> commandHandlers, ObjectProvider<Notification.Handler> notificationHandlers, ObjectProvider<Command.Middleware> middlewares) {
        return new Pipelinr()
                .with(commandHandlers::stream)
                .with(notificationHandlers::stream)
                .with(middlewares::orderedStream);
    }

}

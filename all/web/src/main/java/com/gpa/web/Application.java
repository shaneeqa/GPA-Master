package com.gpa.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

//@Configuration
@SpringBootApplication
@ComponentScan({"com.gpa"})
//@EnableAsync
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, LiquibaseAutoConfiguration.class, SecurityAutoConfiguration.class})
public class Application extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(Application.class);
        Environment environment = springApplication.run(args).getEnvironment();
        LOG.info("\n\n==================================================================\n\nhttp://{}:{}{}\n\n==================================================================",
                InetAddress.getLocalHost().getHostAddress(),
                environment.getProperty("server.port"),
                environment.getProperty("server.servlet.context-path"));
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}

package com.thegreatwall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TheGreatWallApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TheGreatWallApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TheGreatWallApplication.class);
    }
}

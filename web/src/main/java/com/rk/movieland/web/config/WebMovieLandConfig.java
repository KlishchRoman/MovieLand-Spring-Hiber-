package com.rk.movieland.web.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.rk.movieland.web")
public class WebMovieLandConfig implements WebMvcConfigurer {

    private static final Logger logger = LogManager.getRootLogger();
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        logger.debug("Test WebMovieLandConfig");
        configurer.mediaType("json", MediaType.APPLICATION_JSON);
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        logger.debug("Test WebMovieLandConfig");
        registry.enableContentNegotiation(new MappingJackson2JsonView());

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        logger.debug("Test WebMovieLandConfig");
        configurer.enable();
    }
}

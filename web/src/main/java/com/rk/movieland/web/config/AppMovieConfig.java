package com.rk.movieland.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.rk.movieland.persistence",
        "com.rk.movieland.domain",
        "com.rk.movieland.service"})
@Configuration
public class AppMovieConfig {
}

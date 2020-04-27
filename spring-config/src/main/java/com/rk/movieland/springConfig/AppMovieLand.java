package com.rk.movieland.springConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan({"com.rk.movieland.persistence","com.rk.movieland.domain","com.rk.movieland.springConfig"})
@Configuration
public class AppMovieLand {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppMovieLand.class);
        context.getBeanDefinitionNames();
        for (int i = 0; i <context.getBeanDefinitionNames().length ; i++) {
            System.out.println(context.getBeanDefinitionNames()[i]);
        }

    }
}

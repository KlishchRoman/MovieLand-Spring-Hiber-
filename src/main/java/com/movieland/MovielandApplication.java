package com.movieland;

import com.movieland.dao.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MovielandApplication {

    public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(MovielandApplication.class, args);


    }


}

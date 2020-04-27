package web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.concurrent.Future;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "web")
public class WebConfig {

}

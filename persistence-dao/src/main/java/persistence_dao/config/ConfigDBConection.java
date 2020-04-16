package persistence_dao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:persistence_dao.config.properties"),
        @PropertySource("classpath:db.properties")
})
@ComponentScan(basePackages = "persistence_dao")
public class ConfigDBConection {
}

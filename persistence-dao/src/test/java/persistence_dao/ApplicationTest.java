package persistence_dao;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

@ExtendWith(SpringExtension.class)
@ComponentScan(basePackages = "persistence_dao")
@Configuration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class ApplicationTest {

    /*Logger log = Logger.getLogger(ApplicationTest.class.getName());
    String stringMessageFormat = "Сообщение {0}";
*/


    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();


        return dataSource;
       /* DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:default;MV_STORE=false");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        Resource initSchema = new ClassPathResource("schema.sql");
        Resource initData = new ClassPathResource("test-data.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);*/


    }

    @Bean(name = "jdbcTemplateTest")
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }


    @Test
    void foo() {
        assertTrue(!"s".isEmpty());
    }
}

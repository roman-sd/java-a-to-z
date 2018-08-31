package ru.sdroman.carstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author sdroman
 * @since 08.2018
 */
@SpringBootApplication
@EnableJpaRepositories("ru.sdroman.carstore.repository")
public class Application {
    /**
     * Run app.
     *
     * @param args String array
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

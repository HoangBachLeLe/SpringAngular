package de.bach.springcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("PMD.UseUtilityClass")
public class SpringCrudApplication {

    public static void main(final String[] args) throws InterruptedException {
        Thread.sleep(100_000); // wait for db to be ready
        SpringApplication.run(SpringCrudApplication.class, args);
    }

}
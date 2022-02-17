package de.bach.springcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrudApplication {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(100_000); // wait for db to be ready
        SpringApplication.run(SpringCrudApplication.class, args);
    }

}
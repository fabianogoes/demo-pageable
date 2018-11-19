package com.example.demopageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class DemoPageableApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoPageableApplication.class, args);
    }

    @GetMapping
    public String health() {
        return "It's working!!!";
    }

    @Autowired
    CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.asList(
                Customer.builder().name("James Gosling").email("jamesgosling@java.com").build(),
                Customer.builder().name("Guido van Rossum").email("guidovanrossum@python.com").build(),
                Customer.builder().name("Larry Wall").email("larrywall@pearl.com").build(),
                Customer.builder().name("Linus Torvalds").email("linustorvalds@linux.com").build(),
                Customer.builder().name("Rod Johnson").email("Rod Johnson@springframework.com").build()
        ).forEach(repository::save);
    }

}

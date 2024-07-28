package org.acme.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class CustomerService {
    @Produces
    Integer age = 20;

    @Produces
    List<String> leanguages = List.of("Golang", "JavaScript", "TypeScript", "PHP", "Python");
}

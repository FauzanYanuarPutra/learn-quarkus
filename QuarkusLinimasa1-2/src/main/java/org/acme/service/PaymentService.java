package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentService implements Payment {
    
    public void execute() {
        System.out.println("Payment interface Execute");
    }
}

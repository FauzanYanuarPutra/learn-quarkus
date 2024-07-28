package org.acme.rest;

import java.util.List;

import org.acme.service.Payment;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("payment")
public class PaymentResource {

    @Inject
    Payment PaymentService;

    @Inject
    Integer age;

    @Inject
    List<String> leanguages;

    @GET
    public Response getPayment() {
        System.out.println(age);
        System.out.println(leanguages);
        PaymentService.execute();
        return Response.ok().build();
    }
    
}

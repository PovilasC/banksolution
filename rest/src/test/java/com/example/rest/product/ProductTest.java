package com.example.rest.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.example.rest.product.CustomerDetails;
import org.springframework.web.bind.annotation.RequestBody;


class ProductTest {
    CustomerDetails customerDetails;
    @Test
    void postBody() {

     customerDetails =   new CustomerDetails(77, false, 200);
        Product product = new Product();
        String response = product.postBody(customerDetails);
        assertEquals("Senior Account", response);
    }

    @Test
    void sendProductOffer() {
        CustomerDetails customerDetails;
        Product product = new Product();
        String response = product.sendProductOffer("Hello");
        assertEquals("Hello", response);
    }

}
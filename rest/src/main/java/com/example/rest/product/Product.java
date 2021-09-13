package com.example.rest.product;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(
     value = "/api",
     method = POST,
     headers = "Accept=application/json")

@JsonComponent
public class Product {
    CustomerDetails customerDetails;
    @PostMapping("get/products")
    public String makeOffer(@RequestBody CustomerDetails customerDetails) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.print(customerDetails);
        int age = customerDetails.age;
        int income = customerDetails.income;
        boolean student = customerDetails.student;
        String product = "";


        if(age < 18) {
            product = "Junior Saver Account";
        }

        if(age >=65) {
            product = "Senior Account";
        }

        System.out.println(product);
        return product;
    }

}

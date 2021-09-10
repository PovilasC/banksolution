package com.example.rest.product;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.*;

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
    public CustomerDetails postBody(@RequestBody CustomerDetails customerDetails) {
//        System.out.print(customerDetails);
        return customerDetails;
    }


}

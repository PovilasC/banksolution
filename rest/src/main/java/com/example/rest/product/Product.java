package com.example.rest.product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "api/", method = POST)
public class Product {

    @PostMapping("product")
    public String hello() {
        return "Hello";
    }
}

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

//@JsonComponent
public class Product {
    CustomerDetails customerDetails;
    @PostMapping("get/products")
    public String makeOffer(@RequestBody CustomerDetails customerDetails) {
//        System.out.print(customerDetails);
        int age = customerDetails.age;
        int income = customerDetails.income;
        boolean student = customerDetails.student;
        System.out.print(customerDetails.student);
        String product = "";

        // Senior Account
        if(age >= 65 && student == false||true){
            product = "Senior Account";
        }

        // Junior Saver Account
        if(age < 18){
            product = "Junior Saver Account";
        }

        // Current Account Plus
       if(income > 40000 && age > 17 && student == false||true){
           product = "Current Account Plus";
       }
        // Student Account
        if(student == true && age > 17){
            product = "Student Account";
        }
        return product;
    }

}

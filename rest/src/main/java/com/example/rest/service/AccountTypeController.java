package com.example.rest.service;
import com.google.gson.Gson;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.code.gson;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(
     value = "/api",
     method = POST,
     headers = "Accept=application/json")

@JsonComponent
public class AccountTypeController {
    CustomerDetails customerDetails;
    @PostMapping("get/products")
    public String returnOffer(@RequestBody CustomerDetails customerDetails) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Gson gson = new Gson();
        System.out.print(customerDetails);
        int age = customerDetails.age;
        int income = customerDetails.income;
        boolean student = customerDetails.student;
        String accountType = "";

        if(age < 18) {
            accountType = "Junior Saver Account";
        }

        if(age >=65|| age >= 65 && income >= 0) {
            accountType = "Senior Account";
        }

        if(age >17 && income > 0 && age < 64) {
            accountType = "Current Account";
        }

        if(age >17 && income > 40000) {
            accountType = "Current Account Plus";
        }

        System.out.println(accountType);
//        return gson.toJson(accountType);
        return accountType;
    }

}

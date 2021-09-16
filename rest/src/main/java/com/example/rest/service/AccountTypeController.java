package com.example.rest.service;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.rest.service.BankCard;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin(origins = "*")
// RestController takes care of returning POJO as JSON
@RestController
@RequestMapping(
     value = "/api",
     method = POST,
     headers = "Accept=application/json")

@JsonComponent
public class AccountTypeController {
    @PostMapping("get/products")
    public BankCard returnOffer(@RequestBody CustomerDetails customerDetails) throws Exception{
        int age = customerDetails.age;
        int income = customerDetails.income;
        boolean student = customerDetails.student;

        if(age < 18) {
           BankCard bankCard = new BankCard("Junior Saver Account", "Debit");
           return bankCard;
        } else if(age >=65|| age >= 65 && income >= 0) {
            BankCard bankCard = new BankCard("Senior Account", "Debit");
            return bankCard;
        }
         else if(age >17 && income > 40000) {
            BankCard bankCard = new BankCard("Current Account Plus", "Debit");
            return bankCard;
        } else if(age >17 && student == true) {
            BankCard bankCard = new BankCard("Student Account", "Debit");
            return bankCard;
        }
        return new BankCard("Current Account", "Debit");
    }
}

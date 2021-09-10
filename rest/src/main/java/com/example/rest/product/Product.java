package com.example.rest.product;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(
     value = "/api",
     method = POST,
     headers = "Accept=application/json")
public class Product {

    @PostMapping("getproducts")
    public String postBody(@RequestBody String income) {
        System.out.println(income);
        return "your income is "+income;
    }

//    class Details{
//        int age;
//        boolean student;
//        String income;
//
//        public Details(int age, boolean student, String income) {
//            this.age = age;
//            this.student = student;
//            this.income = income;
//        }
//    }
}

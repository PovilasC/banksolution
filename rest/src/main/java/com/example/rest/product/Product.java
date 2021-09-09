package com.example.rest.product;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(
     value = "/api",
     method = POST,
     headers = "Accept=application/json")
public class Product {

    @PostMapping("getproducts")
    public String postBody(@RequestBody int age, boolean student, String income) {
//        System.out.println(age, student, income);
        return "hello";
    }

    class Details(){
        int age;
        boolean student;
        String income;

        public Details(int age, boolean student, String income) {
            this.age = age;
            this.student = student;
            this.income = income;
        }
    }
}

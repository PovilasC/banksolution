package com.example.rest.product;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CustomerDetails {
    int age;
    boolean student;
    int income;

    public CustomerDetails (int age, boolean student, int income) {
        this.age = age;
        this.student = student;
        this.income = income;
    }
}


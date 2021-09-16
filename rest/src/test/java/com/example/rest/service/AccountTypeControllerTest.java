package com.example.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonParseException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import com.google.code.gson;


@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountTypeController.class)
class AccountTypeControllerTest {
//    @Test
//    // testing if we get the right offer based on the input
//    void checkConditionMatch() throws Exception{
//
//    CustomerDetails customerDetails = new CustomerDetails(77, false, 200);
//        Product product = new Product();
//        String response = product.makeOffer(customerDetails);
//        assertEquals("Senior Account", response);
//    }

    @Autowired
    private MockMvc mvc;
    private MvcResult mvcResult;
    private CustomerDetails customerDetails;
    private BankCard bankCard;
    Gson gson = new Gson();

    // check if REST returns correct product offers based on input
    @Test
    void juniorAcc() throws Exception {
        mvcResult = mvc.perform(post("/api/get/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(new CustomerDetails(17, false, 0))))
                .andExpect(status().isOk())
                .andExpect(content()
//                        .string("Junior Saver Account")).andReturn();
                        .json("{\n" +
                                "    \"accountName\": \"Junior Saver Account\",\n" +
                                "    \"bankCardName\": \"Debit\"\n" +
                                "}")).andReturn();
    }

    // check if REST returns correct product offers based on input
    @Test
    void seniorAcc() throws Exception {
        mvcResult = mvc.perform(post("/api/get/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new CustomerDetails(77, false, 0))))
                .andExpect(status().isOk())
                .andExpect(content().string("Senior Account")).andReturn();
    }

    @Test
    void currentAccount() throws Exception {
        mvcResult = mvc.perform(post("/api/get/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(new CustomerDetails(18, false, 1))))
                .andExpect(status().isOk())
                .andExpect(content().string("Current Account")).andReturn();
    }

    @Test
    void currentAccountPlus() throws Exception {
        mvcResult = mvc.perform(post("/api/get/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(new CustomerDetails(18, false, 40001))))
                .andExpect(status().isOk())
                .andExpect(content().string("Current Account Plus")).andReturn();
    }
    @Test
    void studentAccount() throws Exception {
        mvcResult = mvc.perform(post("/api/get/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(new CustomerDetails(18, true, 40001))))
                .andExpect(status().isOk())
                .andExpect(content().string("Student Account")).andReturn();
    }

}
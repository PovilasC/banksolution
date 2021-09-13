package com.example.rest.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
import org.springframework.test.web.servlet.RequestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import com.google.code.gson;


@ExtendWith(SpringExtension.class)
@WebMvcTest(Product.class)
class ProductTest {
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
    Gson gson = new Gson();

    @Test
    void hello() throws Exception {
        // object to test with
        customerDetails = new CustomerDetails(17, false, 0);
        mvcResult = mvc.perform(post("/api/get/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(customerDetails)))
                .andExpect(status().isOk())
//                .andExpect(content().string(gson.toJson("Old"))).andReturn();
                .andExpect(content().string("Young")).andReturn();
    }

    @Test
    void hello2() throws Exception {
        // object to test with
        customerDetails = new CustomerDetails(77, false, 0);
        mvcResult = mvc.perform(post("/api/get/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(customerDetails)))
                .andExpect(status().isOk())
//                .andExpect(content().string(gson.toJson("Old"))).andReturn();
                .andExpect(content().string("Old")).andReturn();

    }

    @Test
    void offerForJunior() throws Exception {

        customerDetails = new CustomerDetails(16, false, 0);
        mvcResult = mvc.perform(post("/api/get/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(customerDetails )))
                .andExpect(status().isOk()).andReturn();
//        assertEquals("Junior Saver Account", mvcResult.getResponse().getContentAsString());
    }

    @Test
    void offerForSenior() throws Exception {
        CustomerDetails customerSenior = new CustomerDetails(65, false, 0);
        mvcResult = mvc.perform(post("/api/get/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(customerSenior)))
                .andExpect(status().isOk()).andExpect(content().string(mapToJson("Senior Account"))).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("Senior Account", content);


    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

}
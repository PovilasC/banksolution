package com.example.rest.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.rest.product.CustomerDetails;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Product.class)
class ProductTest {
    CustomerDetails customerDetails;
    @Test
    // testing if we get the right offer based on the input
    void checkConditionMatch() {

     customerDetails =   new CustomerDetails(77, false, 200);
        Product product = new Product();
        String response = product.makeOffer(customerDetails);
        assertEquals("Senior Account", response);
    }
    @Autowired
    private MockMvc mvc;
    private MvcResult mvcResult;

    @Test
    void hello() {
        CustomerDetails customerDetails = new CustomerDetails(77, false, 200);
        RequestBuilder request = post("/api/get/products" ).requestAttr("person", customerDetails);
        try {
            MvcResult result = mvc.perform(request).andReturn();
            assertEquals("Senior Account", result.getResponse().getContentAsString());
        } catch (Exception handlerException) {
            System.out.println(handlerException);
        }
    }

    @Test
    void sendProductOffer() throws Exception {

        CustomerDetails customerDetails = new CustomerDetails(77, false, 200);
//        RequestBuilder request = post("/api/get/products" ).requestAttr("person", customerDetails);
        mvcResult = mvc.perform(post("/api/get/products").contentType(MediaType.APPLICATION_JSON).content(mapToJson(customerDetails))).andExpect(status().isOk()).andReturn();



//        CustomerDetails customerDetails;
//        Product product = new Product();
//        String response = product.sendProductOffer("Hello");
//        assertEquals("Hello", response);
    }
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

}
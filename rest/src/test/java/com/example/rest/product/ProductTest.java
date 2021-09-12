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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Product.class)
class ProductTest {
    CustomerDetails customerDetails;
    @Test
    // testing if we get the right offer based on the input
    void checkConditionMatch() {

     customerDetails = new CustomerDetails(77, false, 200);
        Product product = new Product();
        String response = product.makeOffer(customerDetails);
        assertEquals("Senior Account", response);
    }
    @Autowired
    private MockMvc mvc;
    private MvcResult mvcResult;

    @Test
    void hello() throws Exception {
        CustomerDetails customerDetails = new CustomerDetails(77, false, 200);
        RequestBuilder request = post("/api/get/products" ).requestAttr("person", customerDetails);
            MvcResult result = mvc.perform(request).andReturn();
            assertEquals("Senior Account", result.getResponse().getContentAsString());
    }

    @Test
    void offerForJunior() throws Exception {
        CustomerDetails customerJunior = new CustomerDetails(16, false, 0);
        mvcResult = mvc.perform(post("/api/get/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(customerJunior )))
                .andExpect(status().isOk()).andReturn();
        assertEquals("Junior Saver Account", mvcResult.getResponse().getContentAsString());
    }

    @Test
    void offerForSenior() throws Exception {
        CustomerDetails customerSenior = new CustomerDetails(65, false, 0);
        mvcResult = mvc.perform(post("/api/get/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapToJson(customerSenior )))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals("Senior Account", content);

    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

}
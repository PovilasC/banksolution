package com.example.rest.service;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountTypeController.class)
class AccountTypeControllerTest {
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
										.json("{\n" +
														"    \"accountName\": \"Junior Saver Account\",\n" +
														"    \"bankCardName\": \"Debit\"\n" +
														"}")).andReturn();
	}

	@Test
	void seniorAcc() throws Exception {
		mvcResult = mvc.perform(post("/api/get/products")
										.contentType(MediaType.APPLICATION_JSON)
										.content(gson.toJson(new CustomerDetails(77, false, 0))))
						.andExpect(status().isOk())
						.andExpect(content()
										.json("{\n" +
														"    \"accountName\": \"Senior Account\",\n" +
														"    \"bankCardName\": \"Debit\"\n" +
														"}")).andReturn();
	}

	@Test
	void seniorAcc2() throws Exception {
		mvcResult = mvc.perform(post("/api/get/products")
										.contentType(MediaType.APPLICATION_JSON)
										.content(gson.toJson(new CustomerDetails(77, false, 13000))))
						.andExpect(status().isOk())
						.andExpect(content()
										.json("{\n" +
														"    \"accountName\": \"Senior Account\",\n" +
														"    \"bankCardName\": \"Debit, Credit\"\n" +
														"}")).andReturn();
	}

	@Test
	void seniorAcc3() throws Exception {
		mvcResult = mvc.perform(post("/api/get/products")
										.contentType(MediaType.APPLICATION_JSON)
										.content(gson.toJson(new CustomerDetails(77, false, 40001))))
						.andExpect(status().isOk())
						.andExpect(content()
										.json("{\n" +
														"    \"accountName\": \"Senior Account\",\n" +
														"    \"bankCardName\": \"Debit, Credit, Gold Credit Card\"\n" +
														"}")).andReturn();
	}

	@Test
	void currentAccount() throws Exception {
		mvcResult = mvc.perform(post("/api/get/products")
										.contentType(MediaType.APPLICATION_JSON)
										.content(gson.toJson(new CustomerDetails(18, false, 1))))
						.andExpect(status().isOk())
						.andExpect(content()
										.json("{\n" +
														"    \"accountName\": \"Current Account\",\n" +
														"    \"bankCardName\": \"Debit\"\n" +
														"}")).andReturn();
	}

	@Test
	void currentAccount2() throws Exception {
		mvcResult = mvc.perform(post("/api/get/products")
										.contentType(MediaType.APPLICATION_JSON)
										.content(gson.toJson(new CustomerDetails(18, false, 12002))))
						.andExpect(status().isOk())
						.andExpect(content()
										.json("{\n" +
														"    \"accountName\": \"Current Account\",\n" +
														"    \"bankCardName\": \"Debit, Credit\"\n" +
														"}")).andReturn();
	}

	@Test
	void currentAccountPlus() throws Exception {
		mvcResult = mvc.perform(post("/api/get/products")
										.contentType(MediaType.APPLICATION_JSON)
										.content(gson.toJson(new CustomerDetails(18, false, 40001))))
						.andExpect(status().isOk())
						.andExpect(content()
										.json("{\n" +
														"    \"accountName\": \"Current Account Plus\",\n" +
														"    \"bankCardName\": \"Debit, Credit, Gold Credit Card\"\n" +
														"}")).andReturn();
	}

	@Test
	void studentAccount() throws Exception {
		mvcResult = mvc.perform(post("/api/get/products")
										.contentType(MediaType.APPLICATION_JSON)
										.content(gson.toJson(new CustomerDetails(19, true, 40003))))
						.andExpect(status().isOk())
						.andExpect(content()
										.json("{\n" +
														"    \"accountName\": \"Student Account\",\n" +
														"    \"bankCardName\": \"Debit, Credit, Gold Credit Card\"\n" +
														"}"))
						.andReturn();
	}

	@Test
	void studentAccount2() throws Exception {
		mvcResult = mvc.perform(post("/api/get/products")
										.contentType(MediaType.APPLICATION_JSON)
										.content(gson.toJson(new CustomerDetails(19, true, 30000))))
						.andExpect(status().isOk())
						.andExpect(content()
										.json("{\n" +
														"    \"accountName\": \"Student Account\",\n" +
														"    \"bankCardName\": \"Debit, Credit\"\n" +
														"}"))
						.andReturn();
	}
}
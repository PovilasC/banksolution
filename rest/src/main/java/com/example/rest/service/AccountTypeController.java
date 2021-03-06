package com.example.rest.service;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.*;
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
	public BankCard returnOffer(@RequestBody CustomerDetails customerDetails) throws Exception {
		int age = customerDetails.age;
		int income = customerDetails.income;
		boolean student = customerDetails.student;

		if (age < 18 && income < 12001) {
			BankCard bankCard = new BankCard("Junior Saver Account", "Debit");
			return bankCard;
		}

		else if (age >= 65 && income < 12001) {
			BankCard bankCard = new BankCard("Senior Account", "Debit");
			return bankCard;
		} else if (age >= 65 && income > 12000 && income < 40000) {
			BankCard bankCard = new BankCard("Senior Account", "Debit, Credit");
			return bankCard;
		} else if (age >= 65 && income >= 40001) {
			BankCard bankCard = new BankCard("Senior Account", "Debit, Credit, Gold Credit Card");
			return bankCard;
		} else if (age > 17 && income > 40000 && !student) {
			BankCard bankCard = new BankCard("Current Account Plus", "Debit, Credit, Gold Credit Card");
			return bankCard;
		} else if (age > 17 && income > 12000 && !student) {
			BankCard bankCard = new BankCard("Current Account", "Debit, Credit");
			return bankCard;
		} else if (age > 17 && student && income < 12001) {
			BankCard bankCard = new BankCard("Student Account", "Debit");
			return bankCard;
		}
		else if (age > 17 && student && income > 12001 && income <=40001) {
			BankCard bankCard = new BankCard("Student Account", "Debit, Credit");
			return bankCard;
		}
		else if (age > 17 && student && income > 40000) {
			BankCard bankCard = new BankCard("Student Account", "Debit, Credit, Gold Credit Card");
			return bankCard;
		}
		else if (age > 17 && student == true && income > 40000) {

			BankCard bankCard = new BankCard("Student Account", "Debit, Credit, Gold Credit Card");
			return bankCard;
		}

		return new BankCard("Current Account", "Debit");
	}
}

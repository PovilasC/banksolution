package com.example.rest.service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
@NotNull
public class BankCard extends AccountType{
	protected String bankCardName;

	public BankCard(String accountName, String bankCardName) {
		super(accountName);
		this.bankCardName = bankCardName;
		this.accountName = accountName;
	}

	public String getBankCardName() {
		return bankCardName;
	}

}

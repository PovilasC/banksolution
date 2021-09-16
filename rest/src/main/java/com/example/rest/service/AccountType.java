package com.example.rest.service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
@NotNull
public class AccountType {
	protected String accountName;

	public AccountType(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountName() {
		return accountName;
	}
}

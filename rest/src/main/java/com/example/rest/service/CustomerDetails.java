package com.example.rest.service;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
@NotNull
public class CustomerDetails {
	protected int age;
	protected boolean student;
	protected int income;

	public CustomerDetails(int age, boolean student, int income) {
		this.age = age;
		this.student = student;
		this.income = income;
	}

	public int getAge() {
		return age;
	}

	public boolean isStudent() {
		return student;
	}

	public int getIncome() {
		return income;
	}
}


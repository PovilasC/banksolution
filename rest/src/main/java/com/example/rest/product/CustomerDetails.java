package com.example.rest.product;

public class CustomerDetails {
    int age;
    boolean student;
    int income;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public CustomerDetails (int age, boolean student, int income) {
        this.age = age;
        this.student = student;
        this.income = income;
    }
    @Override
    public String toString() {
        return "CustomerDetails{" +
                "age=" + age +
                ", student=" + student +
                ", income='" + income + '\'' +
                '}';
    }
}


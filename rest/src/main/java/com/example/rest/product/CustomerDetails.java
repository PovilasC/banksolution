package com.example.rest.product;

public class CustomerDetails {
    int age;
    boolean student;
    String income;

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

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public CustomerDetails (int age, boolean student, String income) {
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


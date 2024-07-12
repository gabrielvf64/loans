package com.gabrielvicente.loans.domain;

public class Customer {
    private Integer age;
    private String cpf;
    private String name;
    private Double income;
    private String location;

    public Customer(Integer age, String cpf, String name, Double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public boolean isIncomeEqualsOrLowerThan(double value) {
        return income <= value;
    }

    public boolean isIncomeBetween(double min, double max) {
        return income >= min && income <= max;
    }

    public boolean isAgeLowerThan(int value) {
        return age < value;
    }

    public boolean isFromLocation(String location) {
        return this.location.equalsIgnoreCase(location);
    }

    public boolean isIncomeEqualsOrGreaterThan(int value) {
        return income >= value;
    }
}

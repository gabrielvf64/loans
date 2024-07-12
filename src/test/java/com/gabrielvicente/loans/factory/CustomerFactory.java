package com.gabrielvicente.loans.factory;

import com.gabrielvicente.loans.domain.Customer;

public class CustomerFactory {

    public static Customer buildCustomerWithIncome(Double income) {
        return new Customer(22, "547.292.888-58", "Pedro", income, "SP");
    }

    public static Customer buildCustomerWithAge(Integer age) {
        return new Customer(age, "547.292.888-58", "Pedro", 5000.0, "SP");
    }

    public static Customer buildCustomerFromLocation(String location) {
        return new Customer(22, "547.292.888-58", "Pedro", 5000.0, location);
    }
}

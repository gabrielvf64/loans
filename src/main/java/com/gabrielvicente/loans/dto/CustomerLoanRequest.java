package com.gabrielvicente.loans.dto;

import com.gabrielvicente.loans.domain.Customer;

public record CustomerLoanRequest(Integer age,
                                  String cpf,
                                  String name,
                                  Double income,
                                  String location) {

    public Customer toDomain() {
        return new Customer(age, cpf, name, income, location);
    }
}

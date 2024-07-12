package com.gabrielvicente.loans.dto;

import com.gabrielvicente.loans.domain.Customer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerLoanRequest(@Min(value = 18) @NotNull Integer age,
                                  @CPF String cpf,
                                  @NotNull String name,
                                  @Min(value = 1000) @NotNull Double income,
                                  @NotBlank String location) {

    public Customer toDomain() {
        return new Customer(age, cpf, name, income, location);
    }
}

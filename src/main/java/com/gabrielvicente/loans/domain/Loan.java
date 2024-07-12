package com.gabrielvicente.loans.domain;

import com.gabrielvicente.loans.exception.LoanNotAvaliableException;

public class Loan {

    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable() {
        if (customer.isIncomeEqualOrLowerThan(3000)) {
            return true;
        }
        return customer.isIncomeBetween(3000, 5000)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }

    public double getPersonalLoanInterestRate() {
        if (isPersonalLoanAvailable()) {
            return 4.0;
        }
        throw new LoanNotAvaliableException();
    }
}

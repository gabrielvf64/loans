package com.gabrielvicente.loans.domain;

import com.gabrielvicente.loans.exception.LoanNotAvaliableException;

public class Loan {

    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public double getPersonalLoanInterestRate() {
        if (isPersonalLoanAvailable()) {
            return 4.0;
        }
        throw new LoanNotAvaliableException();
    }

    public double getConsignmentLoanInterestRate() {
        if (isConsignmentLoanAvailable()) {
            return 2.0;
        }
        throw new LoanNotAvaliableException();
    }

    public Double getGuaranteedLoanInterestRate() {
        if (isGuaranteedLoanAvailable()) {
            return 3.0;
        }
        throw new LoanNotAvaliableException();
    }


    public boolean isPersonalLoanAvailable() {
        return checkGeneralLoanAvaliability();
    }

    public boolean isConsignmentLoanAvailable() {
        return customer.isIncomeEqualsOrGreaterThan(5000);
    }

    public boolean isGuaranteedLoanAvailable() {
        return checkGeneralLoanAvaliability();
    }

    private boolean checkGeneralLoanAvaliability() {
        if (customer.isIncomeEqualsOrLowerThan(3000)) {
            return true;
        }
        return customer.isIncomeBetween(3000, 5000)
                && customer.isAgeLowerThan(30)
                && customer.isFromLocation("SP");
    }
}

package com.gabrielvicente.loans.service;

import com.gabrielvicente.loans.domain.Customer;
import com.gabrielvicente.loans.domain.Loan;
import com.gabrielvicente.loans.domain.LoanType;
import com.gabrielvicente.loans.dto.CustomerLoanRequest;
import com.gabrielvicente.loans.dto.CustomerLoanResponse;
import com.gabrielvicente.loans.dto.LoanResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse checkPossibleLoans(CustomerLoanRequest customerLoanRequest) {
        Customer customer = customerLoanRequest.toDomain();
        Loan loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isConsignmentLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        }

        if (loan.isGuaranteedLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return new CustomerLoanResponse(customerLoanRequest.name(), loans);
    }
}

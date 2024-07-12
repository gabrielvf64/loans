package com.gabrielvicente.loans.controller;

import com.gabrielvicente.loans.dto.CustomerLoanRequest;
import com.gabrielvicente.loans.dto.CustomerLoanResponse;
import com.gabrielvicente.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping(value = "/customer-loans")
    public ResponseEntity<CustomerLoanResponse> checkPossibleLoans(@RequestBody @Valid CustomerLoanRequest customerLoanRequest) {
        CustomerLoanResponse customerLoanResponse = loanService.checkPossibleLoans(customerLoanRequest);
        return ResponseEntity.ok(customerLoanResponse);
    }
}

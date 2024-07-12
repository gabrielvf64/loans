package com.gabrielvicente.loans.dto;

import com.gabrielvicente.loans.domain.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
}

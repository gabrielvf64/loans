package com.gabrielvicente.loans.dto;

import java.util.List;

public record CustomerLoanResponse(String customer,
                                   List<LoanResponse> loans) {
}

package com.gabrielvicente.loans.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualsOrLessThan3k() {
            doReturn(true).when(customer).isIncomeEqualsOrLowerThan(3000);

            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSp() {
            doReturn(false).when(customer).isIncomeEqualsOrLowerThan(3000);
            doReturn(true).when(customer).isIncomeBetween(3000, 5000);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isPersonalLoanAvailable());
        }
    }

    @Nested
    class isGuaranteedAvailable {

        @Test
        void shouldBeAvailableWhenIncomeIsEqualsOrLessThan3k() {
            doReturn(true).when(customer).isIncomeEqualsOrLowerThan(3000);

            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAndAgeIsLessThan30AndLocationIsSp() {
            doReturn(false).when(customer).isIncomeEqualsOrLowerThan(3000);
            doReturn(true).when(customer).isIncomeBetween(3000, 5000);
            doReturn(true).when(customer).isAgeLowerThan(30);
            doReturn(true).when(customer).isFromLocation("SP");

            assertTrue(loan.isGuaranteedLoanAvailable());
        }
    }

    @Nested
    class isConsigmentLoanAvailable {
        @Test
        void shouldBeAvailableWhenIncomeIsEqualsOrGreaterThan5k() {
            doReturn(true).when(customer).isIncomeEqualsOrGreaterThan(5000);

            assertTrue(loan.isConsignmentLoanAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsEqualsTo4k() {
            doReturn(false).when(customer).isIncomeEqualsOrGreaterThan(5000);

            assertFalse(loan.isConsignmentLoanAvailable());
        }
    }

}
package com.gabrielvicente.loans.domain;

import com.gabrielvicente.loans.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Nested
    class isIncomeEqualsOrLowerThan {

        @Test
        void shouldBeTrueWhenIncomeIsEquals() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(5000.0);
            assertTrue(customer.isIncomeEqualsOrLowerThan(5000));
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThan() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(5000.0);
            assertTrue(customer.isIncomeEqualsOrLowerThan(9000));
        }

        @Test
        void shouldBeFalseWhenIncomeIsGreater() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(5000.0);
            assertFalse(customer.isIncomeEqualsOrLowerThan(4000));
        }
    }

    @Nested
    class isIncomeEqualsOrGreaterThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(5000.0);
            assertTrue(customer.isIncomeEqualsOrGreaterThan(5000));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThan() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(5000.0);
            assertTrue(customer.isIncomeEqualsOrGreaterThan(3000));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLower() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(5000.0);
            assertFalse(customer.isIncomeEqualsOrGreaterThan(8000));
        }
    }

    @Nested
    class isIncomeBetween {

        @Test
        void shouldBeTrueWhenIncomeIsBetween() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(5000.0);
            assertTrue(customer.isIncomeBetween(3000, 7000));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotBetween() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(5000.0);
            assertFalse(customer.isIncomeBetween(3000, 4500));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMin() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(5000.0);
            assertTrue(customer.isIncomeBetween(5000, 7000));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMax() {
            Customer customer = CustomerFactory.buildCustomerWithIncome(7000.0);
            assertTrue(customer.isIncomeBetween(5000, 7000));
        }
    }

    @Nested
    class isAgeLowerThan {

        @Test
        void shouldBeTrueWhenAgeIsLower() {
            Customer customer = CustomerFactory.buildCustomerWithAge(25);
            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsNotLowerThan() {
            Customer customer = CustomerFactory.buildCustomerWithAge(31);
            assertFalse(customer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsEquals() {
            Customer customer = CustomerFactory.buildCustomerWithAge(31);
            assertFalse(customer.isAgeLowerThan(31));
        }
    }

    @Nested
    class isFromLocation {

        @Test
        void shouldBeTrueWhenLocationIsTheSame() {
            Customer customer = CustomerFactory.buildCustomerFromLocation("SP");
            assertTrue(customer.isFromLocation("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsNotTheSame() {
            Customer customer = CustomerFactory.buildCustomerFromLocation("SP");
            assertFalse(customer.isFromLocation("RJ"));
        }
    }

}
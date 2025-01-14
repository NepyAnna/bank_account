package com.sheoanna;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(1000.0f, 0.12f);
    }

    @Test
    void testDepositMoney() {
        bankAccount.depositMoney(500.0f);
        assertEquals(1500.0f, bankAccount.getBalance());
        assertEquals(1, bankAccount.getNumberOfDeposits());

    }

    @Test
    void testWithdrawMoneySuccessful() {
        bankAccount.withdrawMoney(200.0f);
        assertEquals(800.0f, bankAccount.getBalance());
        assertEquals(1, bankAccount.getNumberOfWithdrawals());

    }

    @Test
    void testWithdrawMoneyInsufficientFunds() {
        bankAccount.withdrawMoney(2000.0f);
        assertEquals(1000.0f, bankAccount.getBalance());
        assertEquals(0, bankAccount.getNumberOfWithdrawals());
    }

    @Test
    void testCalculateMonthlyInterest() {
        bankAccount.calculateMonthlyInterest();
        assertEquals(1010f, bankAccount.getBalance());
    }

    @Test
    void testMonthlyStatement() {
        bankAccount.setMonthlyFee(0.01f);
        bankAccount.monthlyStatement();
        assertEquals(999.9f, bankAccount.getBalance());
    }

    @Test
    void testToString() {
        String expected = "\nBank Account: \n" +
                "Balance=1000.0,\n" +
                "Number Of Deposits=0,\n" +
                "Number Of Withdrawals=0,\n" +
                "Annual Interest Rate=0.12,\n" +
                "Monthly Fee=0.0";
        assertEquals(expected, bankAccount.toString());
    }

   
}

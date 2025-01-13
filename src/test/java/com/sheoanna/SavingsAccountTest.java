package com.sheoanna;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount(15000.0f, 0.12f);
    }

    @Test
    void testDepositMoneyWhenActive() {
        savingsAccount.depositMoney(5000.0f);
        assertEquals(20000.0f, savingsAccount.getBalance());
        assertEquals(1, savingsAccount.getNumberOfDeposits());
    }

    @Test
    void testDepositMoneyWhenInactive() {
        savingsAccount.setBalance(8000.0f);
        savingsAccount.depositMoney(2000.0f);
        assertEquals(8000.0f, savingsAccount.getBalance());
        assertEquals(0, savingsAccount.getNumberOfDeposits());
    }

    @Test
    void testMonthlyStatementWithExcessWithdrawals() {
        savingsAccount.setNumberOfWithdrawals(6);
        savingsAccount.setBalance(9000.0f);
        assertEquals(9000.0f, savingsAccount.getBalance());
        savingsAccount.monthlyStatement();
        assertEquals(9000.0f, savingsAccount.getBalance());
    }

    @Test
    void testWithdrawMoneyWhenActive() {
        savingsAccount.withdrawMoney(3000.0f);
        assertEquals(12000.0f, savingsAccount.getBalance());
        assertEquals(1, savingsAccount.getNumberOfWithdrawals());

    }

    @Test
    void testWithdrawMoneyWhenInactive() {
        savingsAccount.setBalance(9000.0f);
        savingsAccount.withdrawMoney(2000.0f);
        assertEquals(9000.0f, savingsAccount.getBalance());
        assertEquals(0, savingsAccount.getNumberOfWithdrawals());
    }

    @Test
    void testMonthlyStatementWithoutExcessWithdrawals() {
       savingsAccount.setNumberOfWithdrawals(4);
       savingsAccount.setBalance(11000.0f);
        assertEquals(11000.0f, savingsAccount.getBalance());
        savingsAccount.monthlyStatement();
        assertEquals(11110f, savingsAccount.getBalance());//??
    }

    @Test
    void testToString() {
        String expected = "\nBank Account:\n" +
                "Balance = 15000.0,\n" +
                "Number Of Transactions = 0,\n" +
                "Monthly Fee = 0.0";
        assertEquals(expected, savingsAccount.toString());

    }
}

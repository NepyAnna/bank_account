package com.sheoanna;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    private CurrentAccount currentAccount;

    @BeforeEach
    void setUp() {
        currentAccount = new CurrentAccount(5000.0f, 0.12f);
    }

    @Test
    void testDepositMoney() {
        currentAccount.depositMoney(2000.0f);
        assertEquals(7000.0f, currentAccount.getBalance());
        assertEquals(1, currentAccount.getNumberOfDeposits());
        assertEquals(0.0f, currentAccount.getOverdraft());
    }

    @Test
    void testDepositMoneyWithOverdraftPartialCoverage() {
        currentAccount.withdrawMoney(6000.0f);
        currentAccount.depositMoney(500.0f);
        assertEquals(0.0f, currentAccount.getBalance());
        assertEquals(-500.0f, currentAccount.getOverdraft());
        assertEquals(1, currentAccount.getNumberOfDeposits());
    }

    @Test
    void testDepositMoneyWithOverdraftFullCoverage() {
        currentAccount.withdrawMoney(6000.0f);
        currentAccount.depositMoney(2000.0f);
        assertEquals(1000.0f, currentAccount.getBalance());
        assertEquals(0.0f, currentAccount.getOverdraft());
        assertEquals(1, currentAccount.getNumberOfDeposits());
    }

    @Test
    void testWithdrawMoneyWithinBalance() {
        currentAccount.withdrawMoney(2000.0f);
        assertEquals(3000.0f, currentAccount.getBalance());
        assertEquals(1, currentAccount.getNumberOfWithdrawals());
        assertEquals(0.0f, currentAccount.getOverdraft());
    }

    @Test
    void testWithdrawMoneyWithOverdraft() {
        currentAccount.withdrawMoney(6000.0f);
        assertEquals(0.0f, currentAccount.getBalance());
        assertEquals(-1000.0f, currentAccount.getOverdraft());
        assertEquals(1, currentAccount.getNumberOfWithdrawals());
    }

    @Test
    void testWithdrawMoneyWithExistingOverdraft() {
        currentAccount.withdrawMoney(6000.0f);
        currentAccount.withdrawMoney(500.0f);
        assertEquals(0.0f, currentAccount.getBalance());
        assertEquals(-1500.0f, currentAccount.getOverdraft());
        assertEquals(2, currentAccount.getNumberOfWithdrawals());
    }

    @Test
    void testToString() {
        String expected = "\nBank Account:\n" +
                "Balance=5000.0,\n" +
                "Number Of Transactions =00,\n" +
                "Monthly Fee=0.0,\n" +
                "Overdraft=0.0";
        assertEquals(expected, currentAccount.toString());
    }
}

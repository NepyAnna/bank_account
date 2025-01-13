package com.sheoanna;

public class BankAccount {
    private float balance;
    private int numberOfDeposits;
    private int numberOfWithdrawals;
    private float annualInterestRate;
    private float monthlyFee;

    public BankAccount(float balance, float annualInterestRate) {
        this.balance = balance;
        this.numberOfDeposits = 0;
        this.numberOfWithdrawals = 0;
        this.annualInterestRate = annualInterestRate;
        this.monthlyFee = 0;
    }

    public void depositMoney(float renewal) {
        this.balance += renewal;
        this.numberOfDeposits += 1;
    }

    public void withdrawMoney(float removal) {
        if (removal > this.balance) {
            return;
        }
        this.balance -= removal;
        this.numberOfWithdrawals += 1;
    }

    public void calculateMonthlyInterest() {
        this.monthlyFee = this.annualInterestRate / 12;
        this.balance += this.balance * monthlyFee;
    }

    public void monthlyStatement() {
        this.balance -= this.balance * monthlyFee;
        calculateMonthlyInterest();
    }

    public float getBalance() {
        return balance;
    }

    public int getNumberOfDeposits() {
        return numberOfDeposits;
    }

    public int getNumberOfWithdrawals() {
        return numberOfWithdrawals;
    }

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public float getMonthlyFee() {
        return monthlyFee;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setNumberOfDeposits(int numberOfDeposits) {
        this.numberOfDeposits = numberOfDeposits;
    }

    public void setNumberOfWithdrawals(int numberOfWithdrawals) {
        this.numberOfWithdrawals = numberOfWithdrawals;
    }

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setMonthlyFee(float monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    @Override
    public String toString() {
        return "\nBank Account: \n" +
                "Balance=" + balance +
                ",\nNumber Of Deposits=" + numberOfDeposits +
                ",\nNumber Of Withdrawals=" + numberOfWithdrawals +
                ",\nAnnual Interest Rate=" + annualInterestRate +
                ",\nMonthly Fee=" + monthlyFee;
    }
}

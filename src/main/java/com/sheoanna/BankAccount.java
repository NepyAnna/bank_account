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

    public void withdrawMoney(float removal){
        if(removal > this.balance) {
            return;
        }
        this.balance -= removal;
        this.numberOfWithdrawals += 1;
    }

    public void calculateMonthlyInterest(){
        this.monthlyFee = this.annualInterestRate/12;
        this.balance += this.balance * monthlyFee;
    }

    public void monthlyStatement(){
        this.balance -= this.balance * monthlyFee;
        calculateMonthlyInterest();
    }
    
    @Override
    public String toString() {
        return "\nBankAccount\n" +
            "balance=" + balance +
            ",\n numberOfDeposits=" + numberOfDeposits +
            ",\n numberOfWithdrawals=" + numberOfWithdrawals +
            ",\n annualInterestRate=" + annualInterestRate +
            ",\n monthlyFee=" + monthlyFee;
    }
}

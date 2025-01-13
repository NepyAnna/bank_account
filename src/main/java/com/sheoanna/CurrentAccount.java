package com.sheoanna;

public class CurrentAccount extends BankAccount{
    private float overdraft;

    public CurrentAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        this.overdraft = 0;
    }

    
}

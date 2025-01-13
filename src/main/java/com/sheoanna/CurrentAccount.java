package com.sheoanna;

public class CurrentAccount extends BankAccount {
    private float overdraft;

    public CurrentAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        this.overdraft = 0;
    }

    @Override
    public void withdrawMoney(float removal) {
        if (removal > this.getBalance()) {
            if (this.getOverdraft() == 0) {
                this.overdraft = this.getBalance() - removal;
                this.setBalance(0);
            } else {
                this.overdraft -= removal;
            }
        } else {
            this.setBalance(-removal);
        }
        this.setNumberOfWithdrawals(this.getNumberOfWithdrawals() + 1);
    }

    public void depositMoney(float renewal) {
        if (this.overdraft < 0) {
            float excessAmount = this.overdraft + renewal;
            if (excessAmount > 0) {
                super.depositMoney(excessAmount);
            } else {
                this.overdraft = excessAmount;
                super.depositMoney(0);
            }
        } else {
            super.depositMoney(renewal);
        }
    }

    public float getOverdraft() {
        return overdraft;
    }

    @Override
    public String toString() {
        return "\nBank Account:\n" +
                "Balance=" + this.getBalance() +
                ",\nNumber Of Transactions =" + this.getNumberOfDeposits() + this.getNumberOfWithdrawals() +
                ",\nMonthly Fee=" + this.getMonthlyFee() +
                ",\nOverdraft=" + this.overdraft;
    }
}

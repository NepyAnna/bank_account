package com.sheoanna;

public class SavingsAccount extends BankAccount {
    private boolean isActive;

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        checkIfActive();
    }

    @Override
    public void depositMoney(float renewal) {
        if (checkIfActive()) {
            super.depositMoney(renewal);
        } else {
            System.out.println("Account is inactive. Cannot deposit money.");
        }
    }

    @Override
    public void withdrawMoney(float removal) {
        if (checkIfActive()) {
            super.withdrawMoney(removal);
        } else {
            System.out.println("Account is inactive. Cannot withdraw money.");
        }
        
    }

    @Override
    public void monthlyStatement(){
        if(checkIfActive()){
        if(checkNumberOfWithdrawals()){
            this.setBalance(this.getBalance() - (this.getNumberOfWithdrawals()-4)*1000);
        }
        super.monthlyStatement();
    }
    }

    private boolean checkNumberOfWithdrawals() {
        return this.getNumberOfWithdrawals() > 4;
    }

    private boolean checkIfActive() {
        return this.isActive = this.getBalance() >= 10000;
    }

    @Override
    public String toString() {
        return "\nBank Account:\n" +
            "Balance=" + this.getBalance() +
            ",\nNumber Of Transactions =" + this.getNumberOfDeposits() +this.getNumberOfWithdrawals() +
            ",\nMonthly Fee=" + this.getMonthlyFee();
    }
}

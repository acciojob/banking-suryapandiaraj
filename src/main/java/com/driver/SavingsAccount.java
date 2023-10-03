package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name,0,0);
        // minimum balance is 0 by default
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount > this.maxWithdrawalLimit){
            throw new Exception("Maximum Withdrawal Limit Exceeded");
        }else if(amount > this.getBalance()){
            throw new Exception("Insufficient Balance");
        }else{
            this.setBalance(this.getBalance() - amount);
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return this.getBalance() * this.rate * years / 100;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double principle = this.getBalance();
        return  principle * (Math.pow((1 + this.rate / 100), times * years)) - principle;
    }
}

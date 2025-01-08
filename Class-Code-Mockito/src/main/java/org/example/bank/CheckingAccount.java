package org.example.bank;


public class CheckingAccount extends Account{



    public CheckingAccount(int accountNumber, int balance ) {
        super(accountNumber, balance);
    }

    @Override
    public int withdraw(int amount) {
        return this.getBalance() - amount;
    }

    @Override
    public void deposit(int amount) {

    }

    @Override
    public void checkBalance() {

    }


}


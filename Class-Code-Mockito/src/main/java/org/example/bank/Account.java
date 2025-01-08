package org.example.bank;


public abstract class Account {

    private int accountNumber;
    private int balance;
//    private User owner;
//
//    public Account(int accountNumber, int balance, User owner) {
//        this.accountNumber = accountNumber;
//        this.balance = balance;
//        this.owner = owner;
//    }


    public Account(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public abstract int withdraw(int amount);
    public abstract void deposit(int amount);
    public abstract void checkBalance();

//    public User getOwner() {
//        return owner;
//    }
//
//    public void setOwner(User owner) {
//        this.owner = owner;
//    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
//                ", owner=" + owner +
                '}';
    }


    public String parseToCSV(){
        return
                accountNumber +
                        "," + balance;
    }
}

package org.example.bank;


public class User {




    private String userName;
    private String firstName;
    private String password;
    private Account account;

    public User(String userName, String firstName, String password, Account account) {
        this.userName = userName;
        this.firstName = firstName;
        this.password = password;
        this.account = account;
    }

    public User(String userName, String firstName, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", accounts=" + account +
                '}';
    }

    public String parseToCSV(){
        return
                userName +
                        "," + firstName +
                        "," + password +
                        ","  + account.parseToCSV();
    }
}

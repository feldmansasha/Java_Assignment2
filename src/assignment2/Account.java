package assignment2;

import java.util.Objects;

public class Account {

    private String accountName;
    private int accountNumber;
    private double accountBalance;

    public Account() {}
    public Account(String accountName, int accountNumber, double accountBalance) {
        if(accountName.matches("^[a-zA-Z-(\\s')?]{4,}$")){
            this.accountName=accountName;
        }
        else{
            this.accountName="wrongName";
        }
        String checker = String.valueOf(accountNumber);
        if (checker.matches("\\d{5,9}")) {
            this.accountNumber = accountNumber;
        }
        else{
            this.accountNumber = 99999;
        }

        String balance = String.valueOf(accountBalance);
        if (balance.matches("^-?\\d*\\.?\\d{1,2}?$")) {
            this.accountBalance=accountBalance;
        }
        else{
            this.accountBalance=0;
        }
    }
    public String getAccountName() {
        return Objects.requireNonNullElse(accountName, "wrongName");
    }
    public boolean setAccountName(String accountName) {
        if(accountName.matches("^[a-zA-Z-(\\s')?]{4,}$")){
            this.accountName=accountName;
            return true;
        }
        else{
            return false;
        }
    }
    public int getAccountNumber() { return accountNumber; }
    public boolean setAccountNumber(int accountNumber) {
        String checker = String.valueOf(accountNumber);
        if (checker.matches("\\d{5,9}")) {
            this.accountNumber = accountNumber;
            return true;
        }
        else{
            return false;
        }
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public boolean setAccountBalance(double value) {
        String balance = String.valueOf(value);
        if (balance.matches("^-?\\d*\\.?\\d{1,2}?$")) {
            this.accountBalance=value;
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if (getClass()!=obj.getClass()) {
            return false;
        }
        Account account=(Account) obj;
        return getAccountBalance()==account.getAccountBalance()
                && getAccountNumber()==account.getAccountNumber()
                && getAccountName().equals(account.getAccountName());

    }
    @Override
    public String toString() {
        return String.format("Account Name: %s, Account Number: %d, Balance: %.1f",
                accountName, accountNumber, accountBalance);
    }

}
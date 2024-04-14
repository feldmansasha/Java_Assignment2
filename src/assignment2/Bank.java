package assignment2;

import java.util.*;

public class Bank {
    public static enum BranchLocations {BARRIE, MIDLAND, MUSKOKA, ORANGEVILLE, ORILLIA, TORONTO}
    private String bankName;
    private BranchLocations branchLocation;
    private List<Account> accounts=new ArrayList<>();


    public Bank() {}
    public Bank(String bankName, String branchLocation) {
        if(bankName.matches("(.*&*\\d{0,3}[A-z]){8,}"))
        {
            this.bankName=bankName;
        }
        else{
            this.bankName="wrongBank";
        }
        try {
            this.branchLocation=BranchLocations.valueOf(branchLocation);
        }
        catch (IllegalArgumentException e){
            this.branchLocation=BranchLocations.values()[0];
        }
    }
    public Bank(String bankName, BranchLocations branchLocation) {
        if(bankName.matches("(.*&*\\d{0,3}[A-z]){8,}"))
        {
            this.bankName=bankName;
        }
        else{
            this.bankName="wrongBank";
        }
        try {
            this.branchLocation=branchLocation;
        }
        catch (IllegalArgumentException e){
            this.branchLocation=BranchLocations.values()[0];
        }
    }
    public String getBankName() {
        return Objects.requireNonNullElse(bankName, "wrongBank");
    }
    public boolean setBankName(String bankName) {
        if(bankName.matches("(.*&*\\d{0,3}[A-z]){8,}"))
        {
            this.bankName=bankName;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean setBranchLocation(String branchLocation) {
        try {
            this.branchLocation=BranchLocations.valueOf(branchLocation);
            return true;
        }
        catch (IllegalArgumentException e){
            return false;
        }
    }
    public String getBranchLocation() {
        return Objects.requireNonNullElse(String.valueOf(branchLocation), "BARRIE");
    }

    public boolean setBranchLocation(BranchLocations branchLocation) {
        try {
            this.branchLocation=branchLocation;
            return true;
        }
        catch (IllegalArgumentException e){
            return false;
        }
    }
    public Account getAccountByNumber(int accountNumber) {
        for (Account element : accounts) {
            if (element.getAccountNumber() == accountNumber) {
                return element;
            }
        }
        return new Account();
    }

    public boolean addAccount(Account account) {
        for (Account element: accounts) {
            if (element.equals(account)) {
                return false;
            }
        }
        accounts.add(account);
        return true;
    }
    public boolean addAccount(String accountName, int accountNumber, double accountBalance) {
        Account newElement=new Account(accountName, accountNumber, accountBalance);
        for (Account element: accounts) {
            if (element.equals(newElement)) {
                return false;
            }
        }
        accounts.add(newElement);
        return true;
    }
    public Account viewAccount(int accountNumber) {
        for (Account element : accounts){
            if (element.getAccountNumber() == accountNumber) {
                return element;
            }
        }
        return new Account();
    }
    public Account viewAccount(byte index) {
        for(int i=0; i<accounts.size(); i++){
            if(i==index){
                return accounts.get(index);
            }
        }
        return new Account();
    }
    public boolean modifyAccount(int accountNumber, String accountName) {
        for (Account element : accounts) {
            if (element.getAccountNumber() == accountNumber) {
                element.setAccountName(accountName);
                return true;
            }
        }
        return false;
    }

    public boolean modifyAccount(int accountNumber, double accountBalance) {
        for (Account element : accounts){
            if (element.getAccountNumber() == accountNumber) {
                element.setAccountBalance(accountBalance);
                return true;
            }
        }
        return false;
    }
    public boolean modifyAccount(int accountNumber, String accountName, double accountBalance) {
        for (Account element : accounts){
            if (element.getAccountNumber() == accountNumber) {
                element.setAccountBalance(accountBalance);
                element.setAccountName(accountName);
                return true;
            }
        }
        return false;
    }

    public boolean modifyAccount(byte index, String accountName) {
        for(int i=0; i<accounts.size(); i++){
            if(i==index){
                accounts.get(i).setAccountName(accountName);
                return true;
            }
        }
        return false;
    }
    public boolean modifyAccount(byte index, double accountBalance) {
        for(int i=0; i<accounts.size(); i++){
            if(i==index){
                accounts.get(i).setAccountBalance(accountBalance);
                return true;
            }
        }
        return false;
    }
    public boolean modifyAccount(byte index, String accountName, double accountBalance) {
        for(int i=0; i<accounts.size(); i++){
            if(i==index){
                accounts.get(i).setAccountBalance(accountBalance);
                accounts.get(i).setAccountName(accountName);
                return true;
            }
        }
        return false;
    }
    public boolean deleteAccount(int accountNumber) {
        for(int i=0; i<accounts.size(); i++){
            if(accounts.get(i).getAccountNumber()==accountNumber){
                accounts.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean deleteAccount(byte index) {
        try{
            accounts.remove(index);
            return true;
        }
        catch (IllegalArgumentException e){
            return false;
        }
    }
}

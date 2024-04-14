import assignment2.Account;
import assignment2.Bank;

import static org.junit.Assert.assertTrue;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("ovkzi", "Hw");
        //assertTrue(bank.getBankName() != null && bank.getBankName().length() >= 8 && bank.getBankName().equals(new Bank().getBankName()));
        System.out.println(bank.getBankName() != null);
        System.out.println(bank.getBankName().length() >= 8);
        System.out.println(bank.getBankName().equals(new Bank().getBankName()));
        System.out.println(bank.getBankName());
        System.out.println(new Bank().getBankName());
    }
}
package se.iths.johan.labb2testning.component;

public class AccountComponent {

    private int balance = 0;


    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        this.balance = balance + amount;
    }

    public void withdraw(int amount) {
        this.balance = balance - amount;
    }
}

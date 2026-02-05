package se.iths.johan.labb2testning.component;

import org.springframework.stereotype.Component;

@Component
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

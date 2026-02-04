package se.iths.johan.labb2testning.service;

import se.iths.johan.labb2testning.component.AccountComponent;
import se.iths.johan.labb2testning.exceptions.InsufficientFundsException;
import se.iths.johan.labb2testning.exceptions.InvalidAmountException;
import se.iths.johan.labb2testning.exceptions.MaxWithdrawalExceededException;

public class ATMService {

    private static final int maxWithdrawAmount = 1000;

    private final AccountComponent account;

    public ATMService(AccountComponent account) {
        this.account = account;
    }

    public void withdraw(int amount)
            throws MaxWithdrawalExceededException,
            InvalidAmountException,
            InsufficientFundsException {

        if (amount <= 0) {
            throw new InvalidAmountException("withdrawal amount must be above 0");
        }
        if (amount > maxWithdrawAmount) {
            throw new MaxWithdrawalExceededException("Exceeds max withdrawal amount");
        }
        if (amount > account.getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        account.withdraw(amount);

    }

    public void deposit(int amount)
            throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("deposit amount cant be negative");
        }
        account.deposit(amount);
    }

    public int getBalance() {
        return account.getBalance();
    }


}
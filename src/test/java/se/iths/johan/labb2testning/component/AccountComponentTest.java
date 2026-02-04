package se.iths.johan.labb2testning.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountComponentTest {

    private AccountComponent accountComponent;

    @BeforeEach
    public void setUp() {
        accountComponent = new AccountComponent();
    }


    @Test
    void getBalanceTest() {

        assertEquals(0, accountComponent.getBalance());

    }

    @Test
    void depositTest() {
        accountComponent.deposit(500);
        assertEquals(500, accountComponent.getBalance());

    }

    @Test
    void withdrawTest() {
        accountComponent.deposit(500);
        accountComponent.withdraw(200);
        assertEquals(300, accountComponent.getBalance());


    }

    @Test
    void multibleDepositAndWithdrawalTest() {
        accountComponent.deposit(500);
        accountComponent.withdraw(200);
        accountComponent.withdraw(200);
        assertEquals(100, accountComponent.getBalance());
    }


}

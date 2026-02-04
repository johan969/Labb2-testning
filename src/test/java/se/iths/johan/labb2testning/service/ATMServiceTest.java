package se.iths.johan.labb2testning.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.johan.labb2testning.component.AccountComponent;
import se.iths.johan.labb2testning.exceptions.InsufficientFundsException;
import se.iths.johan.labb2testning.exceptions.InvalidAmountException;
import se.iths.johan.labb2testning.exceptions.MaxWithdrawalExceededException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @Mock
    AccountComponent account;

    @InjectMocks
    ATMService atmService;

    @Test
    public void Withdraw_MaxWithdrawalExceededException_Test() {
        assertThrows(MaxWithdrawalExceededException.class, () -> {
            atmService.withdraw(2000);
        });
        verify(account, never()).withdraw(anyInt());
    }


    @Test
    public void Withdraw_InvalidAmountException_Test() {

        assertThrows(InvalidAmountException.class, () -> {
            atmService.withdraw(-100);
        });
        verify(account, never()).withdraw(anyInt());

    }

    @Test
    public void Withdraw_InsufficientFundsException_Test() {
        when(account.getBalance()).thenReturn(100);
        assertThrows(InsufficientFundsException.class, () -> {
            atmService.withdraw(500);
        });
        verify(account, never()).withdraw(anyInt());
    }

    @Test
    public void Withdraw_NoException_Test() {
        when(account.getBalance()).thenReturn(1000);

        atmService.withdraw(300);

        verify(account).withdraw(300);
    }

    @Test
    public void Deposit_InvalidAmountException_Test() {
        assertThrows(InvalidAmountException.class, () -> {
            atmService.deposit(-100);

        });
        verify(account, never()).deposit(anyInt());


    }

    @Test
    public void Deposit_NoException_Test() {


        atmService.deposit(300);
        verify(account).deposit(300);
    }

    @Test
    public void GetBalance_NoException_Test() {
        when(account.getBalance()).thenReturn(100);
        int result = atmService.getBalance();

        assertEquals(100, result);
        verify(account).getBalance();
    }

}

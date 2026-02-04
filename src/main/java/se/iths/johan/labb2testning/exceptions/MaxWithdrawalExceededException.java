package se.iths.johan.labb2testning.exceptions;

public class MaxWithdrawalExceededException extends RuntimeException {

    public MaxWithdrawalExceededException(String message) {
        super(message);
    }
}

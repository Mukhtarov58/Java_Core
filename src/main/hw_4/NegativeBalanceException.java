package main.hw_4;

public class NegativeBalanceException extends IllegalArgumentException {
    public NegativeBalanceException(String message) {
        super(message);
    }
}

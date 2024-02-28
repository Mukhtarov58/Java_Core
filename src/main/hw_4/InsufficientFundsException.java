package main.hw_4;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(double currentBalance) {
        super("Недостаточно средств для снятия. Текущий баланс: " + currentBalance);
    }
}

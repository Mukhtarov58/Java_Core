package main.hw_4;

public class NegativeInitialBalanceException extends NegativeBalanceException  {
    public NegativeInitialBalanceException() {
        super("Начальный баланс не может быть отрицательным");
    }
}

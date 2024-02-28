package main.hw_4;

public class NegativeDepositAmountException extends NegativeBalanceException {
    public NegativeDepositAmountException() {
        super("Сумма депозита не может быть отрицательной");
    }
}

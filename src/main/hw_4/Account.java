package main.hw_4;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance < 0) {
            throw new NegativeInitialBalanceException();
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new NegativeDepositAmountException();
        }
        this.balance += amount;
        System.out.println("Депозит в размере " + amount + " успешно внесен. Текущий баланс: " + this.balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма снятия не может быть отрицательной");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(balance);
        }

        this.balance -= amount;
        System.out.println("Снятие средств в размере " + amount + " успешно выполнено. Текущий баланс: " + this.balance);
    }

    public double getBalance() {
        return balance;
    }
}

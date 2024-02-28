package main.hw_4;

public class Program {
    public static void main(String[] args) {
        try {
            Account account = new Account(1000);
            System.out.printf("Текущий баланс: %.1f\n", account.getBalance());
            account.deposit(500);
            account.withdraw(300);
            account.withdraw(1200);
            System.out.printf("Текущий баланс: %.1f\n", account.getBalance());
        } catch (NegativeBalanceException | InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

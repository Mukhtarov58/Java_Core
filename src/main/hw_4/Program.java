package main.hw_4;

public class Program {
    public static void main(String[] args) {
        try {
            Account account = new Account(1000);
            account.deposit(500);
            account.withdraw(300);
            account.withdraw(1200);
        } catch (NegativeBalanceException | InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

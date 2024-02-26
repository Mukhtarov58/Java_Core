package main.task4.task_four;

import main.task4.task_four.exceptions.AmountException;
import main.task4.task_four.exceptions.CustomerException;
import main.task4.task_four.exceptions.ProductException;

public class Shop {
    private static Order[] orders = new Order[5];

    public static Order[] getOrders() {
        return orders;
    }

    private static Customer[] customers = {
            new Customer("Иван", 20, "+1-222-333-44-55"),
            new Customer("Петр", 30, "+2-333-444-55-66"),
    };

    private static Item[] items = {
            new Item("Мяч", 100.15),
            new Item("Бутерброд", 110.78),
            new Item("Стол", 15000.02),
            new Item("Машина", 300000),
            new Item("Ракета", 10000000)
    };

    public static Customer[] getCustomers() {
        return customers;
    }

    public static Item[] getItems() {
        return items;
    }

    public static Order buy(Customer who, Item what, int howMuch) throws CustomerException, ProductException, AmountException {
        if (!isInArray(customers, who))
            throw new CustomerException("Неизвестный покупатель: " + who);
        if (!isInArray(items, what))
            throw new ProductException("Неизвестный товар: " + what);
        if (howMuch < 0 || howMuch > 100)
            throw new AmountException("Некорректное кол-во товаров: " + howMuch);
        return new Order(who, what, howMuch);

    }

    /**
     * Вспомогательный метод
     * @param arr Массив
     * @param o Объект для поиска в массиве
     * @return Результат поиска объекта в массиве
     */
    private static boolean isInArray(Object[] arr, Object o) {
        for (Object value : arr) if (value.equals(o)) return true;
        return false;
    }

}


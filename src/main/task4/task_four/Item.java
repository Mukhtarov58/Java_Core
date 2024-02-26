package main.task4.task_four;


/**
 * "Товар"
 */
public class Item {

    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" +
                "Наименование: '" + name + '\'' +
                ", Цена: " + price +
                ']';
    }

}

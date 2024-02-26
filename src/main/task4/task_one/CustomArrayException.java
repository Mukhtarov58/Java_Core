package main.task4.task_one;

public class CustomArrayException extends Exception{

    private final int x;
    private final int y;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CustomArrayException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }
}
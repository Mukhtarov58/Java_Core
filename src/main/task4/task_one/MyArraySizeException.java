package main.task4.task_one;

public class MyArraySizeException extends CustomArrayException{
    public MyArraySizeException(String message, int x, int y) {
        super(message, x, y);
    }
}

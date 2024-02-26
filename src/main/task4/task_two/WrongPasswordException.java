package main.task4.task_two;

public class WrongPasswordException extends Exception {

    public WrongPasswordException(int currentLength, boolean matchConfirm) {
        super();
        this.currentLength = currentLength;
        this.matchConfirm = matchConfirm;
    }

    /**
     * Длина пароля
     */
    private final int currentLength;

    /**
     * Признак совпадения значений пароля и подтверждения пароля
     */
    private final boolean matchConfirm;

    @Override
    public String getMessage() {
        boolean badLength = currentLength <= 20;
        return String.format("Ваш пароль имеет %s длину %s %d. Пароль %s содержит подтверждения.",
                ((badLength) ? "некорректную" : "корректную"),
                ((badLength) ? ", ожидалось > 20, получили" : ","),
                currentLength,
                (matchConfirm) ? "" : "не ");
    }
}

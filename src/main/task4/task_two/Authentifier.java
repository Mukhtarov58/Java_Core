package main.task4.task_two;

/**
 * Структура описывает поля,
 * необходимые для проведения процедуры аутентификации пользователя
 */
public class Authentifier {

    public Authentifier(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }


    /**
     * Имя пользователя
     */
    private final String login;

    /**
     * Пароль
     */
    private final String password;

    /**
     * Подтверждение пароля
     */
    private final String confirmPassword;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

}

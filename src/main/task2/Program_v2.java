package main.task2;

import java.util.Random;
import java.util.Scanner;

public class Program_v2 {
    private static final char DOT_HUMAN = '❌';
    private static final char DOT_AI = '⭕';
    private static final char DOT_EMPTY = '⬜';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static final int WIN_COUNT = 4; // Выигрышная комбинация

    /**
     * Инициализация объектов игры
     */
    static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("- " + (i + 1));
        }
        System.out.println("-");

        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y\n(от 1 до 5) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Поверка на ничью (все ячейки игрового поля заполнены фишками человека или компьютера)
     *
     * @return
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * Метод проверки победы
     *
     * @param dot фишка игрока
     * @return результат проверки победы
     */
    static boolean checkWin(char dot) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (check1(x, y, dot, WIN_COUNT) || check2(x, y, dot, WIN_COUNT) ||
                        check3(x, y, dot, WIN_COUNT) || check4(x, y, dot, WIN_COUNT)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Проверка выигрышной комбинации по горизонтали
     *
     * @param x   координата x
     * @param y   координата y
     * @param dot фишка игрока
     * @param win длина выигрышной комбинации
     * @return true, если есть выигрышная комбинация, иначе false
     */
    static boolean check1(int x, int y, char dot, int win) {
        // Проверяем, что комбинация умещается в пределах поля
        if (y + win <= fieldSizeY) {
            for (int i = 0; i < win; i++) {
                // Если хотя бы одна ячейка не содержит фишку игрока, комбинация не выигрышная
                if (field[x][y + i] != dot) {
                    return false;
                }
            }
            return true; // Если все ячейки содержат фишку игрока
        }
        return false; // Если комбинация не помещается в пределах поля
    }

    /**
     * Проверка выигрышной комбинации по вертикали
     * @param x
     * @param y
     * @param dot
     * @param win
     * @return
     */
    static boolean check2(int x, int y, char dot, int win) {
        if (x + win <= fieldSizeX) {
            for (int i = 0; i < win; i++) {
                if (field[x + i][y] != dot) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Проверка выигрышной комбинации по диагонали в право вниз
      * @param x
     * @param y
     * @param dot
     * @param win
     * @return
     */
    static boolean check3(int x, int y, char dot, int win) {
        if (x + win <= fieldSizeX && y + win <= fieldSizeY) {
            for (int i = 0; i < win; i++) {
                if (field[x + i][y + i] != dot) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Проверка выигрышной комбинации по диагонали в право вверх
      * @param x
     * @param y
     * @param dot
     * @param win
     * @return
     */
    static boolean check4(int x, int y, char dot, int win) {
        if (x - win + 1 >= 0 && y + win <= fieldSizeY) {
            for (int i = 0; i < win; i++) {
                if (field[x - i][y + i] != dot) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Проверка состояния игры
     *
     * @param dot фишка игрока
     * @param s   победный слоган
     * @return состояние игры
     */
    static boolean checkState(char dot, String s) {
        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        } else if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        // Игра продолжается
        return false;
    }

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "Вы победили!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }
}


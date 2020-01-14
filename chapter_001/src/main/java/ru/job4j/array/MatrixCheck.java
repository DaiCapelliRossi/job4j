package ru.job4j.array;

public class MatrixCheck {
    public static boolean monoHorizontal(char[][] board, int row) {
        boolean result = true;
        for (int inner = 0; inner < board.length; inner++) {
            if (board[row][inner] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(char[][] board, int column) {
        boolean result = true;
        for (int outer = 0; outer < board.length; outer++) {
            if (board[outer][column] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }
}


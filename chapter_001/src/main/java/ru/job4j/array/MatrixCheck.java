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
}

package com.leetcode.offer.day4;

/**
 * @author duson
 * <p>
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * 一个数独。
 * <p>
 * <p>
 * <p>
 * 答案被标成红色。
 * <p>
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveSudoku {

    private boolean[][] mRow = new boolean[9][9];

    private boolean[][] mCol = new boolean[9][9];

    private boolean[][] mSquare = new boolean[9][9];

    public void solveSudoku(char[][] board) {

        for (int aRow = 0; aRow < 9; aRow++) {
            for (int aCol = 0; aCol < 9; aCol++) {
                if (board[aRow][aCol] != '.') {
                    int aVal = board[aRow][aCol] - '1';
                    mRow[aRow][aVal] = true;
                    mCol[aCol][aVal] = true;
                    mSquare[(aRow / 3) * 3 + aCol / 3][aVal] = true;
                }
            }
        }

        trySolve(board, 0, 0);
    }

    private boolean trySolve(char[][] board, int pRow, int pCol) {

        if (pRow == -1) {
            return true;
        }

        int aNextRow = pRow + 1;
        int aNextCol = pCol;

        if (aNextRow == 9) {
            aNextRow = 0;
            aNextCol += 1;
        }

        if (aNextCol == 9) {
            aNextRow = -1;
            aNextCol = -1;
        }

        if (board[pRow][pCol] != '.') {
            return trySolve(board, aNextRow, aNextCol);
        }

        final int aBox = (pRow / 3) * 3 + pCol / 3;

        for (int aTry = 0; aTry < 9; aTry++) {

            if (mRow[pRow][aTry] || mCol[pCol][aTry] || mSquare[aBox][aTry]) {
                continue;
            }

            board[pRow][pCol] = (char) (aTry + '1');

            mRow[pRow][aTry] = true;
            mCol[pCol][aTry] = true;
            mSquare[aBox][aTry] = true;

            if (trySolve(board, aNextRow, aNextCol)) {
                return true;
            }

            mRow[pRow][aTry] = false;
            mCol[pCol][aTry] = false;
            mSquare[aBox][aTry] = false;

        }

        board[pRow][pCol] = '.';
        return false;
    }

    private static void print(char[][] board) {
        for (int aRow = 0; aRow < 9; aRow++) {
            for (int aCol = 0; aCol < 9; aCol++) {
                System.out.print(board[aRow][aCol] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SolveSudoku solveSudoku = new SolveSudoku();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println("===before========");

        print(board);

        solveSudoku.solveSudoku(board);

        System.out.println("===after=========");

        print(board);

    }
}

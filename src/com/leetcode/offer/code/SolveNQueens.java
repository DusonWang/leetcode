package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens {

    private boolean[] col = null;

    private boolean[] left = null;

    private boolean[] right = null;

    private List<List<String>> ret = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        left = new boolean[2 * n - 1];
        right = new boolean[2 * n - 1];
        char[][] board = new char[n][n];
        backTrack(board, 0, n);
        return ret;

    }

    private void backTrack(char[][] board, int r, int n) {
        if (r >= n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            ret.add(list);
            return;
        }
        Arrays.fill(board[r], '.');
        for (int i = 0; i < n; i++) {
            if (!col[i] && !left[r + i] && !right[r - i + n - 1]) {
                col[i] = true;
                left[r + i] = true;
                right[r - i + n - 1] = true;
                board[r][i] = 'Q';
                backTrack(board, r + 1, n);
                col[i] = false;
                board[r][i] = '.';
                left[r + i] = false;
                right[r - i + n - 1] = false;
            }
        }
    }


    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
    }
}
